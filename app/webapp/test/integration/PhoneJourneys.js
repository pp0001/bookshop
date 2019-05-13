jQuery.sap.require("sap.ui.qunit.qunit-css");
jQuery.sap.require("sap.ui.thirdparty.qunit");
jQuery.sap.require("sap.ui.qunit.qunit-junit");
QUnit.config.autostart = false;

sap.ui.require([
	"sap/ui/test/Opa5",
	"bookshop/app/test/integration/pages/Common",
	"sap/ui/test/opaQunit",
	"bookshop/app/test/integration/pages/App",
	"bookshop/app/test/integration/pages/Browser",
	"bookshop/app/test/integration/pages/Master",
	"bookshop/app/test/integration/pages/Detail",
	"bookshop/app/test/integration/pages/NotFound"
], function (Opa5, Common) {
	"use strict";
	Opa5.extendConfig({
		arrangements: new Common(),
		viewNamespace: "bookshop.app.view."
	});

	sap.ui.require([
		"bookshop/app/test/integration/NavigationJourneyPhone",
		"bookshop/app/test/integration/NotFoundJourneyPhone",
		"bookshop/app/test/integration/BusyJourneyPhone"
	], function () {
		QUnit.start();
	});
});