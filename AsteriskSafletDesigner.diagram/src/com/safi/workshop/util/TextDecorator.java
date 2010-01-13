package com.safi.workshop.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.Text;

/**
 * This class is a little number decorator. By simply changing the pattern it can become
 * another decorator (e.g. a DateDecorator).
 */
public class TextDecorator {

  Text _text;
  private Pattern _pattern;
  private boolean isModified;
  private boolean _isValid;
  private Object _data;

  public TextDecorator(Text text, String pattern) {
    _text = text;
    _pattern = Pattern.compile(pattern);
    isModified = false;
    _isValid = false;
    attachListeners();
  }

  // public boolean forceValidation() {
  // _isModified = true;
  // doMatch();
  // return isValid();
  // }

  public boolean forceValidation() {
    isModified = true;
    return isValid();
  }

  public boolean isValid() {
    doMatch();
    return _isValid;
  }

  /**
   * attach all nessessary listeners to the underlying text widget.
   */
  private void attachListeners() {
    _text.addTraverseListener(new TraverseListener() {
      public void keyTraversed(TraverseEvent e) {
        doMatch();
      }
    });

    _text.addFocusListener(new FocusListener() {
      public void focusGained(FocusEvent e) {
        _text.selectAll();
      }

      public void focusLost(FocusEvent e) {
        if (isModified) {
          if (_text.getText().length() != 0) {
            doMatch();
            if (!isValid())
              _text.setText("");
          }
        }
      }
    });

    _text.addModifyListener(new ModifyListener() {
      public void modifyText(ModifyEvent e) {

        setModified(true);
      }
    });
  }

  /**
   * check if text matches to the defined pattern and create 'real' object representing
   * that text.
   */
  private void doMatch() {
    if (isModified) {
      _isValid = false;

      // get text of widget
      String text = _text.getText();
      if (text.length() != 0) {
        Matcher matcher = _pattern.matcher(text);
        // check if it matches the pattern
        boolean matches = matcher.matches();
        if (matches) {

          _data = getValue(matcher.group(0));
          if (_data != null) {
            // set the textual representation of that value
            String textresult = _data.toString();
            if (!textresult.equals(text))
              _text.setText(textresult);
            _isValid = true;
          } else {
            // something was wrong
            matches = false;
            _isValid = false;
          }
        }

        if (!matches)
          _text.selectAll();
      }
      isModified = false;
    }
  }

  /**
   * When changing the pattern that method must be overwritten.
   * 
   * @param value
   *          textual representation of real value
   * @return 'real' value
   */
  Object getValue(String value) {
    try {
      // get real value of matched value
      return Long.valueOf(value);
    } catch (NumberFormatException e) {
      // something was wrong with that value (e.g. it was to large)
      return null;
    }
  }

  public Object getData() {
    return _data;
  }

  public boolean isModified() {
    return isModified;
  }

  public void setModified(boolean isModified) {
    this.isModified = isModified;
  }
}
