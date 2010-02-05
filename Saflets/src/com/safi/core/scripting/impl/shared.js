function now() {
	return new java.util.Date();
}

function debug(text) {
	Packages.com.safi.asterisk.saflet.impl.SafletImpl.debugLog.debug(text);
}

function info(text) {
	Packages.com.safi.asterisk.saflet.impl.SafletImpl.debugLog.info(text);
}

function error(text) {
	Packages.com.safi.asterisk.saflet.impl.SafletImpl.debugLog.error(text);
}

function print(text) {
	java.lang.System.out.print(text);
}

function printCurrentRequest() {
	if (request)
		println(request);
}

function getGlobalVariable(name) {

	var val = _handler_environment_.getGlobalVariableValue(name);
	if (val != '' && typeof (val) == 'object'
			&& val.getClass().getName() == 'java.lang.Long')
		return val.intValue()

	return val;
}

function setGlobalVariable(name, value) {
	_handler_environment_.setGlobalVariableValue(name, value);
}

function getSessionVariable(name) {
	return _handler_context_.getSessionVar(name);
}

function setSessionVariable(name, value) {
	_handler_context_.setSessionVar(name, value);
}