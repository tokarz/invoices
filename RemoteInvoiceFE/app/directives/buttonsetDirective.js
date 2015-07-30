'use strict';
app.directive('mmtButtonset', function() {
	return {
		restrict : 'C',
		link : function(scope, element, attribute) {
			element.buttonset();
		}
	}

});