jQuery.sap.require("sap.ui.qunit.qunit-css");
jQuery.sap.require("sap.ui.thirdparty.qunit");
jQuery.sap.require("sap.ui.qunit.qunit-junit");
QUnit.config.autostart = false;

// We cannot provide stable mock data out of the template.
// If you introduce mock data, by adding .json files in your webapp/localService/mockdata folder you have to provide the following minimum data:
// * At least 3 Books in the list

sap.ui.require([
	"sap/ui/test/Opa5",
	"bookshop/app/test/integration/pages/Common",
	"sap/ui/test/opaQunit",
	"bookshop/app/test/integration/pages/App",
	"bookshop/app/test/integration/pages/Browser",
	"bookshop/app/test/integration/pages/Master",
	"bookshop/app/test/integration/pages/Detail",
	"bookshop/app/test/integration/pages/Create",
	"bookshop/app/test/integration/pages/NotFound"
], function (Opa5, Common) {
	"use strict";
	Opa5.extendConfig({
		arrangements: new Common(),
		viewNamespace: "bookshop.app.view."
	});

	sap.ui.require([
		"bookshop/app/test/integration/MasterJourney",
		"bookshop/app/test/integration/NavigationJourney",
		"bookshop/app/test/integration/NotFoundJourney",
		"bookshop/app/test/integration/BusyJourney",
		"bookshop/app/test/integration/FLPIntegrationJourney"
	], function () {
		QUnit.start();
	});
});