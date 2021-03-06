
# About this document

This file contains the tasks/issues which we implement in metasfresh, in a chronological fashion (latest first)

Additional notes:
 * The metasfresh source code is hosted at https://github.com/metasfresh/metasfresh
 * The metasfresh website is at http://metasfresh.com/en, http://metasfresh.com/ (german)
 * You can also follow us on twitter: @metasfresh (english), @metasfreshDE (german)

Here come the actual release notes:

# metasfresh 5.12 (2017-22)

**upcoming release for week 2017-22**

## Features

* metasfresh-backend
  * [#1564](https://github.com/metasfresh/metasfresh/issues/1564) New Window for Packing Material in WebUI
    * New Window that allows to maintain Packing Material in WebUI.
  * [#1599](https://github.com/metasfresh/metasfresh/issues/1599) Import full menu from w101
    * Initial Import of the current full webUI Menu/ Sitemap.
  * [#1619](https://github.com/metasfresh/metasfresh/issues/1619) Do not process reverse booking lines and improve esr import
  * [#1641](https://github.com/metasfresh/metasfresh/issues/1641) New Tax Rate window in WebUI
    * Adding the Tax Rate Window to WebUI.
  * [#1647](https://github.com/metasfresh/metasfresh/issues/1647) Rename Empties Return in language de_DE
    * Translation of Emptires Return Window in WebUI. Renamed window, tab and menu entry.
  * [#1654](https://github.com/metasfresh/metasfresh/issues/1654) Customer Returns Window in WebUI
    * Creating the Customer Returns Window for WebUI. Adding to the menu.
  * [#1659](https://github.com/metasfresh/metasfresh/issues/1659) Make verify BOM available in webUI 
  * [#1657](https://github.com/metasfresh/metasfresh/issues/1657) Initially set Date+Time Filters in WebUI
    * Removing 2 Date Fields from Filter criteria in WebUI that did not have a perfect behavior when using combined filters.
  * [#1661](https://github.com/metasfresh/metasfresh/issues/1661) make process field autocomplete in table and columns window
  * [#1665](https://github.com/metasfresh/metasfresh/issues/1665) Subtab Advanced Edit Configurations
    * Migrating all Subtab UI Elements to show them in Advanced Edit, also swicthing the UI Element Group UI Styles to be not primary.
  * [#1672](https://github.com/metasfresh/metasfresh/issues/1672) New Tax Category Window in WebUI
    * New Window for the Tax Category Maintenance.
  * [#1676](https://github.com/metasfresh/metasfresh/issues/1676) Payment Terms window in WebUI
    * Adding the window Layout For Payment Term window in WebUI.
  * [#1679](https://github.com/metasfresh/metasfresh/issues/1679) New Window for Country in WebUI
    * New Window in WebUI allowing the maintaineance of Country, Regions and Cities
  * [#1680](https://github.com/metasfresh/metasfresh/issues/1680) New Window or Request Type in WebUI
    * Creation of the Window Layoutfor the Request Type Window in WebUI.
 
 
* metasfresh-webui-api
  * [#413](https://github.com/metasfresh/metasfresh-webui-api/issues/413) Subtab Fields not shown in Advanced Edit although Displayed = 'Y'
    * Now the Subtab Fields are shown in Advanced Edit mode when Displayed = 'Y'.
  * [#414](https://github.com/metasfresh/metasfresh-webui-api/issues/414) Referenced Windows for Subtab Records
    * New Functionality to jump to referenced data from SUbtab rows. Opens a new browser Tab with the referenced window and record.
  * [#416](https://github.com/metasfresh/metasfresh-webui-api/issues/416) AD_UI_Section's Name and Description shall be translatable
    * The Section Names for Fieldgroup creation are now translatable in WebUI.
    
* metasfresh-webui-frontend
  * [#713](https://github.com/metasfresh/metasfresh-webui-frontend/issues/713) KPIs: In case datasets is empty or missing shall show "No data" text
    * The Dashboard now does sow "No data" instaead of error, when no Data is available.
  * [#781](https://github.com/metasfresh/metasfresh-webui-frontend/issues/781) Sorting of Included Tab columns
    * Now it is possible to sort in Included Subtabs. Also possible now: Intial Order By criteria via Window Layout.
  * [#790](https://github.com/metasfresh/metasfresh-webui-frontend/issues/790) Advanced edit section header for better structuring
    * Adding the possibility to have Fieldgroups in WebUI Advanced Edit Windows.

## Fixes

* metasfresh-backend
  * [#1559](https://github.com/metasfresh/metasfresh/issues/1559) Minor Invoice Layout Issues
  * [#1656](https://github.com/metasfresh/metasfresh/issues/1656) No Packing Item in jaspers
  
* metasfresh-webui-frontend
  * [#714](https://github.com/metasfresh/metasfresh-webui-frontend/issues/714) Included tab shall preserve the retrieve order
    * When opening the window in WebUI, the fontend now respects the ordering sequence transmitted by the webui-api.


# metasfresh 5.11 (2017-21)

## Features

* metasfresh-backend
  * [#1389](https://github.com/metasfresh/metasfresh/issues/1389) Make eMail adress fields longer
    * Enhancing the lenght of the eMail address field in Business Partner Contact Window/ Tab. Allowing also to include multiple eMail Addresses semicolon seperated.
  * [#1506](https://github.com/metasfresh/metasfresh/issues/1506) Add the possibility to track easily contracts that ended naturally
    * New feature that adds more transparency to the contract management, allowing to easily track contracts that are resigned.
  * [#1507](https://github.com/metasfresh/metasfresh/issues/1507) Add the possibility to close or not invoice candidates when canceling a contract
    * New feature that prohibits invoice candidates to be invoiced after ther referenced contract has been terminated.
  * [#1560](https://github.com/metasfresh/metasfresh/issues/1560) Add description fields to invoice window
    * Adding the Prefix and Suffix Description Fields for Invoice Documents. These Fields allow the user to write an individual text that shall be shown in the beginning and at the end of an Invoice Doument.
  * [#1577](https://github.com/metasfresh/metasfresh/issues/1577) Introduce /test/ping/notifications server troubleshooting endpoint
    * Internal Issue adding a Testing possibility that checks if websockets is available after starting metasfresh.
  * [#1584](https://github.com/metasfresh/metasfresh/issues/1584) New Window for Org in WebUI
    * Adding a window that allows the maintenance of Organisations in WebUI.
  * [#1585](https://github.com/metasfresh/metasfresh/issues/1585) New Window Client in WebUI
    * Adding a window that allows the maintenance of Clients in WebUI.
  * [#1586](https://github.com/metasfresh/metasfresh/issues/1586) New Window for OrgType in WebUI
    * Adding a window that allows the maintenance of Organisation Type Settings in WebUI.
  * [#1591](https://github.com/metasfresh/metasfresh/issues/1591) Password Field is missing in user window in WebUI
    * Adding the Password Field in User Window of WebUI.
  * [#1595](https://github.com/metasfresh/metasfresh/issues/1595) Translate Important Doc Types to en_US
    * Translation for a subset of Document Types to Language en_US.
  * [#1598](https://github.com/metasfresh/metasfresh/issues/1598) update jaxb maven plugin to 2.3.1
    * Solves an internal issue updating the jaxb maven plugin to new version 2.3.1
  * [#1602](https://github.com/metasfresh/metasfresh/issues/1602) Show manufactoring order documentno in production order overview
    * Now the Manufacturing Order No. is shown in Grid overview
  * [#1606](https://github.com/metasfresh/metasfresh/issues/1606) Add IsQualityReturnWarehouse flag to warehouse window WebUI
    * Adding the new Field isQualityReturnWarehouse to Main View of Warehouse Window in WebUI.
  * [#1609](https://github.com/metasfresh/metasfresh/issues/1609) Provide Basic Test config Data for manufacturing / production
    * Includes some initial settings for manufacturing that provides a good starting point for new users in this topic.
  * [#1612](https://github.com/metasfresh/metasfresh/issues/1612) New Window for Business Partner Group in WebUI
    * Created a new Window in WebUI that allows different settings for Business Partner Groups.
  * [#1614](https://github.com/metasfresh/metasfresh/issues/1614) New Window Attribute Set Instance in WebUI
    * Adds the new Window for Attribute Set Maintenance to WebUI.
  * [#1617](https://github.com/metasfresh/metasfresh/issues/1617) Check if imported esr file is v11 file
    * Adding a consitency check in Swiss ESR File Processing, allowing to import files only w/ the defined format.
  * [#1621](https://github.com/metasfresh/metasfresh/issues/1621) Adjustments of Pricelist window in WebUI
    * Adjusting the Pricelist Window in WebUI, renaming Fields, Adding Translations, Order by Valid from in Subtab.
  * [#1627](https://github.com/metasfresh/metasfresh/issues/1627) Adjustments of Business Partner window in WebUI
    * Adjustments, Refining of Business Partner Window with Subtabs and new Fields.
  * [#1628](https://github.com/metasfresh/metasfresh/issues/1628) Sales Order Window Advanced edit rearrangement
    * Refining the Sales Order window for a better Layout and Look and Feel. Rearranging the Advanced edit to allow better visibility and navigation.
  * [#1642](https://github.com/metasfresh/metasfresh/issues/1642) Column Resizing in Sales Order Grid View
    * Finetuning in Sales Order Grid View, making important fields larger so their content is not cut off.
  * [#1650](https://github.com/metasfresh/metasfresh/issues/1650) Resize Fields in Pricelist Window and Field and Layout adjustments
    * Adding various windget sizes to fields shown in Grid View (Main and Subtab) to allow a better visibility, readability)

* metasfresh-webui-api
  * [#396](https://github.com/metasfresh/metasfresh-webui-api/issues/396) Vendor Return Actions in WebUI
    * Adding the Vendor Return Actions to WebUI Handling Unit Editor in Material Receipt.
  * [#409](https://github.com/metasfresh/metasfresh-webui-api/issues/409) backend: change view attributes endpoint location
    * Internal Issue about switching the Attributes endpoint in WebUI.
  * [#411](https://github.com/metasfresh/metasfresh-webui-api/issues/411) Provide "size" to layout element
    * New feature for Admins, allowing to change the size of widgets in grid view to allow a better distribution of columns on each data table.
  * [#412](https://github.com/metasfresh/metasfresh-webui-api/issues/412) Provide API for sorting included tab
    * Functionality that allows to define sorting critieria for included tabs.
  
  
* metasfresh-webui-frontend
  * [#762](https://github.com/metasfresh/metasfresh-webui-frontend/issues/762) Empty Filter vs. Default Value in Window Filtering
    * New Design and Functionality for the Filter Definition of Y/N Fields.
  * [#763](https://github.com/metasfresh/metasfresh-webui-frontend/issues/763) grid: right click on a cell and zoom into
    * New Zoom-To Functionality in grid rows, allowing the user to right click on a table cell and selecting Zoo-To. A new browser Tab is created with the referenced window and record.
  * [#764](https://github.com/metasfresh/metasfresh-webui-frontend/issues/764) Long text boxes shall have a border around
    * New Layout element for long text fields. These fields now have a surrounding visible border.
  * [#765](https://github.com/metasfresh/metasfresh-webui-frontend/issues/765) Date + Time Info in Notification window
    * Adds Date and Time Infomration as Tooltip Overlay in Notification window.
  * [#772](https://github.com/metasfresh/metasfresh-webui-frontend/issues/772) automatic Column sizing not showing all text although space would be available
    * Optimizing the Size mechanism für Window and Field Layout createn.
  * [#778](https://github.com/metasfresh/metasfresh-webui-frontend/issues/778) Yellow pulse effect w/o data change
    * Restricting the pulse effect only to changed data.
  * [#787](https://github.com/metasfresh/metasfresh-webui-frontend/issues/787) window endpoint: change "attribute" to "field"
    * Adjusting API Calls, chinging used endpoints to avoid using deprecated ones.
  
## Fixes

* metasfresh-backend
  * [#1566](https://github.com/metasfresh/metasfresh/issues/1566) Invoicing problem with reversed inouts that have a quality discount
    * Fix that solves an issue when processing Invoice candidates that are associated with inoutlines which are reversed and have a quclity discount recorded.
  * [#1578](https://github.com/metasfresh/metasfresh/issues/1578) spring-boot services try to start local broker and fail
    * Internal task that solves an issue with failing spring boot services.
  * [#1607](https://github.com/metasfresh/metasfresh/issues/1607) DB Function dba_seq_check_native needs to explicitly work in public schema
    * Fixes an issue in sequence generation, trying to create sequences in wrong, active db schemas.
  * [#1615](https://github.com/metasfresh/metasfresh/issues/1615) Address lines is cut off on shipment jasper document
    * Resizing and adjustments of Address lines in documents. Thanks to @thelightsense for reporting and testing
  * [#1624](https://github.com/metasfresh/metasfresh/issues/1624) NPE when closing the pp_order
    * Fixing a Bug that caused a Null Pointer Exception after closinf a manufacturing Order.
  * [#1639](https://github.com/metasfresh/metasfresh/issues/1635) cannot complete distribution order
    * Fixing a Bug that restricted the closing of Distribution Orders.
 
* metasfresh-webui-api
  * [#378](https://github.com/metasfresh/metasfresh-webui-api/issues/378) Document changes: provide the validStatus and saveStatus only when changed
    * Adjustments to the API of Documents, now prividing the validStatus/ saveStatus only when these are change.
  * [#405](https://github.com/metasfresh/metasfresh-webui-api/issues/405) Backend shall provide JSON document fields indexed by field's name
    * Internal Issue to improve performance using name indexed JSON document fields in Map.
  * [#407](https://github.com/metasfresh/metasfresh-webui-api/issues/407) View filtering by virtual SQL column not working
    * Fixing the usage of virtual columns in Filtering criteria.

* metasfresh-webui-frontend
  * [#753](https://github.com/metasfresh/metasfresh-webui-frontend/issues/753) Location dropdown missing in Order windows
    * Fixes the missing Dropdown List for Locations in combined Businesspartner Lookups.  
  * [#760](https://github.com/metasfresh/metasfresh-webui-frontend/issues/760) Fix the texts displayed while loading
    * Optimizing the Text shown to the user when lazy loading actions and referenced.
  * [#766](https://github.com/metasfresh/metasfresh-webui-frontend/issues/766) issue panel doesn't open
    * Fixes a Bug in Manufacturing Action Issue and Receipt opening the Issue modal overlay.
  * [#767](https://github.com/metasfresh/metasfresh-webui-frontend/issues/767) Got same notification several times
    * Avoiding the creation of notifications multiple times.
  * [#769](https://github.com/metasfresh/metasfresh-webui-frontend/issues/769) Honor tab stale flag also when editing in advanced mode
    * Now honoring the stale flag of included tabs also in Advanced edit mode of main view.
  * [#774](https://github.com/metasfresh/metasfresh-webui-frontend/issues/774) Fix invalid "GET /window/{windowId}/{tabId} call
    * Fixing an invalid GET after completing a sales Order.
  
# metasfresh 5.10 (2017-20)

## Features

* metasfresh-backend
  * [#1304](https://github.com/metasfresh/metasfresh/issues/1304) Jasper Document for Material disposal
    * New Jasper Report for the Material disposal Document.
  * [#1306](https://github.com/metasfresh/metasfresh/issues/1306) Customer Returns Functionality
    * New Functionality for the customer Returns workflow, allowing to receive and book the returns including Packing Material and empties.
  * [#1474](https://github.com/metasfresh/metasfresh/issues/1474) New Window Handling Unit Packing Instruction in WebUI
    * Creates a new Packing Instruction Window in WebUI.
  * [#1475](https://github.com/metasfresh/metasfresh/issues/1475) New Window for Handling Unit Packing Instruction Item in WebUI
    * Creates a new Window in WebUI allowing the maintenance of Packing Instruction Versions.
  * [#1485](https://github.com/metasfresh/metasfresh/issues/1485) New Window Distribution Order in WebUI
    * Adding the Distribution Order window to WebUI.
  * [#1489](https://github.com/metasfresh/metasfresh/issues/1489) Disable/delete legacy Cockpit window
    * Disabling the legacy Business Partner Cockpit Window.
  * [#1501](https://github.com/metasfresh/metasfresh/issues/1501) Rename "No Handling Unit" and "Virtual PI" PIs
    * Renames the internal Packing Items (former Virtual PI, No Handling Unit) to names that describe what these Items really are.
  * [#1504](https://github.com/metasfresh/metasfresh/issues/1504) Configure our services for logstash
    * Add an option to have metasfresh-backend, -admin, -material-dispo and -webui-api send log messages to an ELK Stack
  * [#1509](https://github.com/metasfresh/metasfresh/issues/1509) New Window for Doctype in WebUI
    * Adding a new Window for Doctype in webUI allowing the admin user to maintain Document Types via Web User Interface.
  * [#1517](https://github.com/metasfresh/metasfresh/issues/1517) intern: refactor LanguageDAO and LanguageBL
    * Internal issue, refactoring and improving the language handling in metasfresh.
  * [#1520](https://github.com/metasfresh/metasfresh/pull/1520) add .metadata/ and .recommenders/ to .gitignore
    * Thx to @homebeaver
  * [#1523](https://github.com/metasfresh/metasfresh/issues/1523) New Window for Print Format in WebUI
    * New Window in WebUI to allow doing the Print Format maintenance.
  * [#1524](https://github.com/metasfresh/metasfresh/issues/1524) New Window for Document Sequence in WebUI
    * Adding the Document Sequence Window in webUI allowing the admin user to have control over the Document Sequences in metasfresh.
  * [#1529](https://github.com/metasfresh/metasfresh/issues/1529) Fresh Migration of WebUI Menu for rel. 5.10
    * Adding the new Menu Configuration for WebUI.
  * [#1539](https://github.com/metasfresh/metasfresh/issues/1539) New Window for Product BOM in WebUI
    * Adding the BOM Product Window to WebUI. Now allowing the easy BOM Configuration via the Web User Interface.
  * [#1541](https://github.com/metasfresh/metasfresh/issues/1541) New Window for Packing Configuration in WebUI
    * Adding the Packing Configuration (readonly) Window to webUI.
  * [#1546](https://github.com/metasfresh/metasfresh/issues/1546) Add login Field to User Window in WebUI Main View
    * Move the Login Field from Advanced Edit to Main View in User Window of WebUI.
  * [#1551](https://github.com/metasfresh/metasfresh/issues/1551) Jasper Document for Customer Returns
    * New Jasper Report for the Customer Returns Document.
  * [#1555](https://github.com/metasfresh/metasfresh/issues/1555) add default search fields for business partner window
    * Adding default search filters for the Business Partner Window in WebUI.
  * [#1561](https://github.com/metasfresh/metasfresh/issues/1561) Rearrange Role Window w/ more important fields on Main view
    * Adjustments of Main View and advanced Edit field content in Role Window. Moving Fields according to their importance/ usage.
  * [#1572](https://github.com/metasfresh/metasfresh/issues/1572) User Window adjustment in WebUI
    * Adjustment of User Window in WebUI, Harmonizing Look&Feel, important Fields to Main View.
  * [#1574](https://github.com/metasfresh/metasfresh/issues/1574) New Field for Menu Root Node in Role window of WebUI
    * Adding a new Field to Role Window of WebUI, Menu Root Node ID, allowing to define partial Menus as Main Menu for a given Role.

* metasfresh-webui-api
  * [#362](https://github.com/metasfresh/metasfresh-webui-api/issues/362) Add filters in Handling Units window
    * Adding default filters to the Handling Unit Window in WebUI.
  * [#364](https://github.com/metasfresh/metasfresh-webui-api/issues/364) Replace HU editor's Barcode quick action with Barcode filter
    * Replacing the action based Barcode selection with the new special Barcode Filter.
  * [#366](https://github.com/metasfresh/metasfresh-webui-api/issues/366) Make Permission change active without server cache reset
    * First Implemantation of the distributed Cache invalidation. Now it's possible to change role permissions without the need of a  server cache reset. 
  * [#370](https://github.com/metasfresh/metasfresh-webui-api/issues/370) Avoid spamming the console with "Connection refused" when elasticsearch connection is not available
    * Housekeeping task about log messages when elasticsearch is not available.
  * [#372](https://github.com/metasfresh/metasfresh-webui-api/issues/372) backend: endpoint for creating a filtered view
    * New Functionality in WebUI backend that allows to provide filtered views for the frontend.
  * [#388](https://github.com/metasfresh/metasfresh-webui-api/issues/388) grid view: select "ALL" support
    * New Feature that allows to select more records than are visible on the page. The new selection possibility allows the user to select all records which are available with the current filtering. These selected records can then also be used for following processes or quickactions.
  * [#390](https://github.com/metasfresh/metasfresh-webui-api/issues/390) Change advanced edit layout
    * Adjusting the advanced edit mode to the Main View Layout. This makes it easier for the user to find additional fields that are not displayed on Main View and makes a more tidy look & feel.
  * [#391](https://github.com/metasfresh/metasfresh-webui-api/issues/391) role: besides menu tree, allow configuring the sub-tree to be used
    * New feature that allows an easier Menu maintenance in future via Menu Nodes that can be selected as Root of main menu for a given role.

  
* metasfresh-webui-frontend
  * [#679](https://github.com/metasfresh/metasfresh-webui-frontend/issues/679) Record selection behavior w/ browser back/ forward
    * New Implementation of a refined Browser Navigation in metasfresh. It is now possible to use the browser back button and also persist the previously made selection in Grid View Lines.
  * [#738](https://github.com/metasfresh/metasfresh-webui-frontend/issues/738) Use Key in long drop down list
    * New Alphanumeric key handling in drop down list. The user can press the first key and the cursor jumps to the first found apperarance in the drop down list.
  * [#739](https://github.com/metasfresh/metasfresh-webui-frontend/issues/739) When included view is displayed add an alpha layer over the main view
    * The new included view implementation is now better focussable for the user. The remaining non active main view has an opacity overlay, to avoid distraction for the user.
  * [#740](https://github.com/metasfresh/metasfresh-webui-frontend/issues/740) When filtering a view please use the newly introduced "/documentView/{windowId}/{viewId}/filter" endpoint
    * Internal housekeeping task moving the filtering implementations to a new endpoint.
  * [#742](https://github.com/metasfresh/metasfresh-webui-frontend/issues/742) Filter singleOverlayField support
    * Adding a new Overlay method to WebUI allowing to create special Filtering screens. First implementation done with Barcode Filter functionality in Manufacturing Issue and Receipt Editor.
  * [#743](https://github.com/metasfresh/metasfresh-webui-frontend/issues/743) modal panel: background looks a bit ugly
    * Adjustment of the Look and Fied design of the modal overlay.
  * [#752](https://github.com/metasfresh/metasfresh-webui-frontend/issues/752) Select-all-filtered option in general
    * Providing the possibility to use the select-all filtering generally/ systemwide.

## Fixes

* metasfresh-backend
  * [#1515](https://github.com/metasfresh/metasfresh/issues/1515) Project "de.metas.material.dispo" shall not be part of Swing client
    * Extracting the project material dispo from swing client.
  * [#1516](https://github.com/metasfresh/metasfresh/issues/1516) HU Transform - split out some TUs from LU does not work correctly with custom LUs
    * Fix for the Split Functionality in handling Unit Editor. Sometimes the Split off for Transport Units did not work properly.
  * [#1521](https://github.com/metasfresh/metasfresh/issues/1521) standard database: add SSCC attribute to "DIM_Barcode_Attributes" dimension spec
    * Adding the SSCC Attribute to the default database seed of metasfresh.
  * [#1580](https://github.com/metasfresh/metasfresh/issues/1580) NPE when setting up production ressource
    * Fixing a Null Pointer Exception when inserting an new manufacturing ressource.

* metasfresh-webui-api
  * [#302](https://github.com/metasfresh/metasfresh-webui-api/issues/302) jasper processes default values not taken
    * Fix for Jasper Processing in WebUI. In a minor case some default values were not considered when doing the Jasper Processing.
  * [#363](https://github.com/metasfresh/metasfresh-webui-api/issues/363) make LU not mandatory in Receive HUs
    * Fix for the Field Logistic Unit in Receive Handling Units action. Now allowing to receive without a Logistics Unit.
  * [#369](https://github.com/metasfresh/metasfresh-webui-api/issues/369) adding role to user does not work
    * Fix for Role Permissions in WebUI. Adding of new Users to a roles was not working anymore.
  * [#377](https://github.com/metasfresh/metasfresh-webui-api/issues/377) Don't show zoom-to for non-zoom reference Lists
    * Restricting the new zoom-to action in WebUI. Not allowing non-zoom reference Lists anymore.
  * [#381](https://github.com/metasfresh/metasfresh-webui-api/issues/381) ZoomInto shall consider AD_Ref_List.AD_Reference_ID if any
    * Enhancing zoom-to, now considering the Reference List ID if available.
  * [#380](https://github.com/metasfresh/metasfresh-webui-api/issues/380) readonly permission in webui
    * Possibility to use the readonly Layout configuration also in WebUI now.
  * [#382](https://github.com/metasfresh/metasfresh-webui-api/issues/382) menu is not updating when you change permission
    * After changing a permission in Role window, the menu was not adjusted to the new permission.
  * [#386](https://github.com/metasfresh/metasfresh-webui-api/issues/386) Purchase Order from Sales Order Parms not initially filled in WebUI
    * Now setting the needed default values in Processes when calling actions from window Main view.
  * [#375](https://github.com/metasfresh/metasfresh-webui-api/issues/375) Adding Role for User w/o Org_access restricts access totally
    * Fixing a Bug with All Orgs Access permission, which restricted the access totally after setting.
  * [#389](https://github.com/metasfresh/metasfresh-webui-api/issues/389) Zoom-Into error for subtab orderline
    * Fixing a Bug when using zoom-to for subtab lines of a main window.
  * [#392](https://github.com/metasfresh/metasfresh-webui-api/issues/392) barcode field is readonly
    * Fix of the barcode field. Was readonly and should be editable.
  * [#393](https://github.com/metasfresh/metasfresh-webui-api/issues/393) Manufacturing Issue/Receipt: cannot receive HUs
    * Fix for the receive Handling Units error, that prevented the receipt of new Handling Units.
  
* metasfresh-webui-frontend
  * [#706](https://github.com/metasfresh/metasfresh-webui-frontend/issues/706) Manufacturing order - Issue HUs - wrong /quickActions call
    * Fix for the action menu behavior in Manufacturing Order Window of WebUI. Now the actions are fitting to the selected rows and context.
  * [#707](https://github.com/metasfresh/metasfresh-webui-frontend/issues/707) Page popup shall be closed when clicking o a page
    * The Page selection popup now closes automatically when clicking on a page selection.
  * [#715](https://github.com/metasfresh/metasfresh-webui-frontend/issues/715) KPI widgets shall have the same height
    * Adjustment to the KPI widget heights. Now all widgets have the same height and result in a tidier look and feel of the metasfresh Dashboard.
  * [#732](https://github.com/metasfresh/metasfresh-webui-frontend/issues/732) issue not opening on single document
    * Fixing an error that avoided the opening of the action issue window in Manufaturing workflow.
  * [#734](https://github.com/metasfresh/metasfresh-webui-frontend/issues/734) included view: don't reset when closing an error notification
    * Fix in included view. Not resetting the context anymore when clicking on an error notification.
  * [#749](https://github.com/metasfresh/metasfresh-webui-frontend/issues/749) singleOverlayField: pressing ESC shall close the popup
    * Fix for the single field overlay, now allowing to press [esc] to close that overlay.
  * [#751](https://github.com/metasfresh/metasfresh-webui-frontend/issues/751) Initial Setup Wizard does not open after switching language
    * Fixing a Bug in Initial setup wizard that did not open anymore when using the language selector previously.
  * [#755](https://github.com/metasfresh/metasfresh-webui-frontend/issues/755) mandatory numeric field is underlined with blue, even if it's set
    * Adjustment in the mandatory field look & feel for number fields. Although a number was set, the mandatory logic said that the fields still has to be recorded.
  * [#759](https://github.com/metasfresh/metasfresh-webui-frontend/issues/759) Action button remains gray if the process execution fails with error 404
    * Fixing an error leaving the action button greyed out after running into a previous 404 error.

# metasfresh 5.9 (2017-19)

## Features

* metasfresh-backend
  * [#1305](https://github.com/metasfresh/metasfresh/issues/1305) Jasper Document for Vendor Returns
    * Created a new Jasper Document that allows to Vendor Return Confirmation.
  * [#1320](https://github.com/metasfresh/metasfresh/issues/1320) Translation for nl_NL in WebUI
    * Initial Translation for nl_NL for multiple WebUI Windows and elements. Thanks to @Arjanvb for this contribution.
  * [#1460](https://github.com/metasfresh/metasfresh/issues/1460) The Bestellkontrolle barcodes shall be generated and persisted in database
    * New Barcode Generator for the Order Control report in Manufacuring. This Barcode is needed to the scan possibility in Manufacturing when starting the action issue and receipt workflow in WebUI.
  * [#1463](https://github.com/metasfresh/metasfresh/issues/1463) Add Window for S_Resource_Ressource to WebUI
    * Adding a new window to WebUI to allow maintaining Manufacturing Resources.
  * [#1464](https://github.com/metasfresh/metasfresh/issues/1464) New Window for Manufacturing Workflow in WebUI
    * Adding the Manufacturing Workflow Window to WebUI, now allowing to maintain these.
  * [#1465](https://github.com/metasfresh/metasfresh/issues/1465) New Window for Distribution Network in WebUI
    * Including the Distribution Network Window in WebUI.
  * [#1466](https://github.com/metasfresh/metasfresh/issues/1466) New Window for Resource Type in WebUI
    * Adding the ResourceType maintenance Window to WebUI.
  * [#1467](https://github.com/metasfresh/metasfresh/issues/1467) New Window for Product Planning Data in WebUI
    * Including the Window Product Planning Data to WebUI, to allow the user to maintain Manufacturing dependant data for products.
  * [#1471](https://github.com/metasfresh/metasfresh/issues/1471) Provide material-dispo and spring-boot-admin as services
    * New Material Disposition Framework alowing to start the "Make or Buy" decision nearly just-in-time. This implementation is preparing the gound for the furture metasfresh microservices framework
  * [#1473](https://github.com/metasfresh/metasfresh/issues/1473) New Window for Node Transitions in webUI
    * Creating a new Window in WebUI for Node Transition maintenance in Manufacturing Workflow.
  * [#1478](https://github.com/metasfresh/metasfresh/issues/1478) New Window for InvoiceSchedule in WebUI
    * Adding the Invoice Schedule Window to WebUI to allow the user to define invoiceing frequencies.
  * [#1486](https://github.com/metasfresh/metasfresh/issues/1486) Add Status Field to Material Disposition Window in WebUI
    * Adding the Status Field to Material Disposition Window in WebUI. Minor Adjustments in window Layout.
  * [#1487](https://github.com/metasfresh/metasfresh/issues/1487) Allow the editing of Workflow Node in Window
    * Adjustment in Window Workflow Node Transition, now allowing the user to select the Workflow Node.
  * [#1494](https://github.com/metasfresh/metasfresh/issues/1494) Add HU_PI_Item to Product Price Window in WebUI
    * Adding the Field Handling Unit Packing Instruction to Product Price Window. Minor Adjustments in Layout.
  * [#1499](https://github.com/metasfresh/metasfresh/issues/1499) Update to spring-boot 1.5.3
    * Updating spring-boot from 1.4.2 to version 1.5.3
  * [#1502](https://github.com/metasfresh/metasfresh/issues/1502) Drop the CU-TU assignment for "No PI" (M_HU_ID=100)
    * Dropping the Customer Unit/Transport Unit assignment creation for "No Packing Instructions2 Handling Units.

* metasfresh-webui-api
  * [#280](https://github.com/metasfresh/metasfresh-webui-api/issues/280) Scan of Barcode "Bestellkontrolle" for Manufacturing execution
    * New Functionality for manufacturing action issue/ receipt processing, allowing the user to scan the Order control report for efficient workflow start.
  * [#348](https://github.com/metasfresh/metasfresh-webui-api/issues/348) backend: Implement Zoom-into in webUI
    * New usability feature for zoom-into. Fields with references to other records now create a link to the corresponding records via available field label.
  * [#352](https://github.com/metasfresh/metasfresh-webui-api/issues/352) Introduce JSONLayoutType.primaryLongLabels
    * Introducing a new Lable LayoutType for longer label names.
  * [#354](https://github.com/metasfresh/metasfresh-webui-api/issues/354) Support for Record_ID buttons
    * New Functionality for table-ID record-ID buttons, allowing the user to navigate quickly into the referenced window.
  * [#356](https://github.com/metasfresh/metasfresh-webui-api/issues/356) Manufacturing Quickaction: Reverse Issue / Receipt
    * New quickaction allowing the reverse issues/ receipts planning in Action-receipt and -issue window of manufacturing in WebUI.
  * [#357](https://github.com/metasfresh/metasfresh-webui-api/issues/357) Manufacturing Quickaction: Issue selected HU w/ TU Quantity parm
    * New Quickaction in manufacturing issue/ receipt window. Allowing to issue Handling Units with a predefined quantity of Transport Units.

* metasfresh-webui-frontend
  * [#216](https://github.com/metasfresh/metasfresh-webui-frontend/issues/216) Button record_id does not open according window
    * Frontend implementation of table-id/ record-id buttons.
  * [#716](https://github.com/metasfresh/metasfresh-webui-frontend/issues/716) Image widget: button to clear current image
    * New button that allows to clear the current saved image.
  * [#719](https://github.com/metasfresh/metasfresh-webui-frontend/issues/719) Document references: group them by their top level menu
    * New Grouping functionality in referenced documents sidelist allowing a better usability.
  * [#720](https://github.com/metasfresh/metasfresh-webui-frontend/issues/720) Implement Zoom-into in webUI
    * Implementation of the new Zoom-into functionality in WebUI.

* other
  * [#1](https://github.com/metasfresh/metasfresh-dev/issues/1) extend metasfresh-eclipse-config repo to generally contain dev resources
    * Extension of the metasfresh-eclipse-config repository to generally contain development resources
  * [#2](https://github.com/metasfresh/metasfresh-dev/issues/2) add Vagrantfile for developers
    * Adding Vagrantfile for Developers.
  * [#3](https://github.com/metasfresh/metasfresh-admin/issues/3) create docker image for metasfresh-admin
    * Creating a docker image for usage of metasfresh-admin.

## Fixes

* metasfresh-backend
  * [#1179](https://github.com/metasfresh/metasfresh/issues/1179) Process logs are not displayed in Swing
    * Fixes an exception of processe which create process logs in swing client.

* metasfresh-webui-api
  * [#255](https://github.com/metasfresh/metasfresh-webui-api/issues/255) Document fields: when receiving empty string values from frontend, convert them to nulls
    * Converting empty string values to null for document fields.
  * [#351](https://github.com/metasfresh/metasfresh-webui-api/issues/351) Fix NPE when opening Materialdisposition
    * Fixes a Null Pointer Exception that happend when opening the Material Disposition Window in WebUI.
  * [#360](https://github.com/metasfresh/metasfresh-webui-api/issues/360) Material receipt candidates: Error while Receving HUs for a particular case
    * Fixes an error that occured in Material receipt window when trying to receive Handling units for a minor case.

* metasfresh-webui-frontend
  * [#705](https://github.com/metasfresh/metasfresh-webui-frontend/issues/705) Debug/Fix why /window/540189 shows empty
    * Fix in webui. Window 540189 was only shown as empty screeen.
  * [#717](https://github.com/metasfresh/metasfresh-webui-frontend/issues/717) Sidelist's scrollbar is on wrong container.
    * Adding the sidelist scrollbar now in the correct container.
  * [#724](https://github.com/metasfresh/metasfresh-webui-frontend/issues/724) Login role selection keyboard down does not scroll automatically
    * Fixing the login role selection. Now allowing the user to also select and see roles also in long role lists.
  * [#725](https://github.com/metasfresh/metasfresh-webui-frontend/issues/725) Sidelist closes when doubleclick
    * Fixing the sidelist navigational behavior. When selecting a record the sidelist now remains sticky, until the user closes it via "oustide" cklick.
  * [#727](https://github.com/metasfresh/metasfresh-webui-frontend/issues/727) Grid view: reset current page to 1 when filtering
    * Fixes the filtering functionality in grid view. Retestting the page counter to 1 after adding new Filter criteria.

# metasfresh 5.8 (2017-18)

## Features

* metasfresh-backend
  * [#796](https://github.com/metasfresh/metasfresh/issues/796) Fact Account WebUI Window Readonly
    * Including the Fact Account window to WebUI.
  * [#886](https://github.com/metasfresh/metasfresh/issues/866) Make payment callouts work in webui
    * Implementation in WebUI to also allow the Payment Callouts there.
  * [#1315](https://github.com/metasfresh/metasfresh/issues/1315) 2D Barcode wit ad_table_id/ record_id on bestellkontrolle
    * Add a 2D Barcode to each line of Order control report for manufacturing and logistics. This Barcode will be used in manufacturing to scan and trigger the manufacturing Order issue/ receipt record and workflow.
  * [#1362](https://github.com/metasfresh/metasfresh/issues/1362) Activate auto numbering for incoming and outgoing payments
    * Adjusting the Document Type setting for incoming and outgoing payment Documents. Now allowing the Document No. to be automatically create taken from Document sequences in WebUI.
  * [#1369](https://github.com/metasfresh/metasfresh/issues/1369) Translate request type to de_DE Vorgang Art
    * Adding the Translation of Request Type in webUI for language en_US.
  * [#1398](https://github.com/metasfresh/metasfresh/issues/1398) Take out "New" in C_DocTypeTarget_ID in PP_Order
    * Adjusted the behavior of Manufacturing Order Document when manually created. Taken out the Document Target "New", which only confuses user when selectable.
  * [#1399](https://github.com/metasfresh/metasfresh/issues/1399) DocumentNo not generated for PP_Orders in WebUI
    * Adding Document No. control to all manufacturing Document Types.
  * [#1400](https://github.com/metasfresh/metasfresh/issues/1400) DocumentNo not generated for empties in WebUI
    * Adding the Document No. control to the empties return document.
  * [#1401](https://github.com/metasfresh/metasfresh/issues/1401) Translate Process "New Request" to de_DE
    * Translating the jump Navigation of "New Request" to de_DE.
  * [#1403](https://github.com/metasfresh/metasfresh/issues/1403) technical: refactor TaxNotFoundException
    * Technical Task to make the Tax selection easier and more robust in background implementation.
  * [#1405](https://github.com/metasfresh/metasfresh/issues/1405) Adjust Empties Return Window to mandatory field grouping layout
    * Adjusting empties Return Window to mandatory Field primary layout.
  * [#1408](https://github.com/metasfresh/metasfresh/issues/1408) Create the WebUI Layout for Material Candidates
    * Creating the initial Layout for the Material Candidates Window in WebUI.
  * [#1411](https://github.com/metasfresh/metasfresh/issues/1411) Possible 1:1 switch for Data Lifecycle Management users
    * New feature to allow individual users to be switched on/ off for the Data Lifecycle Management functionality. Before it was only possible to switch all users on for the same environment.
  * [#1417](https://github.com/metasfresh/metasfresh/issues/1417) Window for c_activity in WebUI
    * Adding the Activity window to WebUI.
  * [#1418](https://github.com/metasfresh/metasfresh/issues/1418) Window for c_bank in WebUI
    * Adding the Bank Master data window definition to WebUI.
  * [#1419](https://github.com/metasfresh/metasfresh/issues/1419) Window for c_currency in WebUI
    * Adding the Currency master data window definition to WebUI.
  * [#1424](https://github.com/metasfresh/metasfresh/issues/1424) Fresh Migration of WebUI Menu for rel. 5.8
    * Building an updated menue in WebUI for Release 5.8
  * [#1425](https://github.com/metasfresh/metasfresh/issues/1425) make price field bigger in sales invoice document
    * Resizing the price field in sales Invoice document, now allowing greater prices.
  * [#1429](https://github.com/metasfresh/metasfresh/issues/1429) Window for Bank Account in WebUI
    * Created a new Bank Account window and added to WebUI
  * [#1430](https://github.com/metasfresh/metasfresh/issues/1430) Window for c_conversion_rate in WebUI
    * Adding the Currency Conversion rate window to WebUI.
  * [#1432](https://github.com/metasfresh/metasfresh/issues/1432) technical: HUReportService shall work with AD_Process_ID instead of I_AD_Process
    * Technical Task to improve performance and reduce possible caching issues.
  * [#1435](https://github.com/metasfresh/metasfresh/issues/1435) Add method for Escaping '@' char, by replacing one @ with double @@
    * Internal Implementation, allowing to escape @ characters.
  * [#1438](https://github.com/metasfresh/metasfresh/issues/1438) Fix spring scanBasePackageClasses and introduce profiles
    * Adjusting the spring boot configurations for the different metasfresh applications to allow a better maintenance.
  * [#1442](https://github.com/metasfresh/metasfresh/issues/1442) Window for C_Doc_Outbound_Config in WebUI
    * This new Window in WebUI allows to do the configuration of outbound Documents.
  * [#1444](https://github.com/metasfresh/metasfresh/issues/1444) Window for C_Doc_Outbound_Log in WebUI
    * New Window for the maintenance of outbound Documents in webUI.
  * [#1446](https://github.com/metasfresh/metasfresh/issues/1446) Add filter to currency conversion window in WebUI
    * Adding Filter criteria to currency conversion window.
  * [#1451](https://github.com/metasfresh/metasfresh/issues/1451) Add scale Price Tab in Window Product Price
    * Adding the Scale Price Tab in Product Price Window on WebUI.
  * [#1456](https://github.com/metasfresh/metasfresh/issues/1456) Translation of Initial Setup Wizard Process Window and Menu entry
    * Translation of Initial Client Setup Added to WebUI Menu for language en_US

* metasfresh-webui-api
  * [#325](https://github.com/metasfresh/metasfresh-webui-api/issues/325) make error message more clear when printing in receipt candidates
    * Enhancing error messages in Printing Framework, now allowing to receive a helpful error message when printing fails.
  * [#330](https://github.com/metasfresh/metasfresh-webui-api/issues/330) Implement webui HUEditor support for massive amount of HUs
    * Enhancing the WebUI Handling Unit Editor to allow performant usage also when loading mass data Handling Units.
  * [#334](https://github.com/metasfresh/metasfresh-webui-api/issues/334) switch filters to primary layout
    * Improving the usability and readability of process Parameters, switching the labels and fields to primary layout there.
  * [#344](https://github.com/metasfresh/metasfresh-webui-api/issues/344) backend: Document references: group them by their top level menu
    * New Layout feature in Document references for better visibility. Grouping the referenced in Sidelist via their top level (1 beneath root) Navigation node. This is the backend task, waiting for frontend implementation in the next week to visualize the reference results.

## Fixes

* metasfresh-backend
  * [#1044](https://github.com/metasfresh/metasfresh/issues/1044) System Elements w/ centrally maintained Y shall also migrate migration scripts for Translations
    * Now allowing more efficient Translation creation. System elements with centrally maintained = 'Y' now also create migration scripts when adjusted.
  * [#1353](https://github.com/metasfresh/metasfresh/issues/1353) Problem with C_Order filtering in M_ShipmentSchedule
    * Fixes a Bug when filtering Document No. and more than 1 exact result is returned. Added validation rule to exclude Purchase Orders from Search.
  * [#1440](https://github.com/metasfresh/metasfresh/issues/1440) ClassCastException: CompositeQueryFilter cannot be cast to SqlQueryFilter
    * Fixes a Bug that was introduced in Data Lifecycle Task and caused a Null Pointer Exception in Doc Outbound eMail functionality .

* metasfresh-webui-api
  * [#257](https://github.com/metasfresh/metasfresh-webui-api/issues/257) BPartner contact cannot be saved because mandatory field Name is not set
    * Fixing a Bug that Business Partner record was not saved because mandatory name field was not set. Implemented a callout which  builds the Name when the user changes Firstname or Lastname.
  * [#333](https://github.com/metasfresh/metasfresh-webui-api/issues/333) HUs child and parent get separated when both selected on issue
    * Fixes a Bug that seperated the Child-Parent-Handling Units of a Component when issueing to Manufacturing Order.
  * [#339](https://github.com/metasfresh/metasfresh-webui-api/issues/339) Sales Order also show Purchase Orders
    * Fixes a Bug that showed Purchase Orders also in the Sales Order Window.
  * [#340](https://github.com/metasfresh/metasfresh-webui-api/issues/340) Manufacturing order: Prevent issuing VHUs which are not top level
    * Fixing a Bug that did not handle Sub Handling Units correctly when selected during manufacturing Issue.
  * [#341](https://github.com/metasfresh/metasfresh-webui-api/issues/341) Apply role permissions when browsing/editing data
    * Fixes a Role Permission issue when browsing and editing data.
  * [#342](https://github.com/metasfresh/metasfresh-webui-api/issues/342) Exception in WebUI when opening initial Doc Outbound window
    * Fixes a Bug that occured when opening the new Doc Outbound window in WebUI.
  * [#345](https://github.com/metasfresh/metasfresh-webui-api/issues/345) Batch entry not working in order
    * Fixes the Batch entry in Order Windows, which was nor working anymore due to internal error.
  * [#346](https://github.com/metasfresh/metasfresh-webui-api/issues/346) Zoom into error
    * Fixing the Zoom-Accross functionality via document references.


* metasfresh-webui-frontend
  * [#675](https://github.com/metasfresh/metasfresh-webui-frontend/issues/675) Icons for manufacturing components
    * Changing the icons for manufacturing element types in Action Issue and Receipt window on WebUI to allow a better visibility.
  * [#697](https://github.com/metasfresh/metasfresh-webui-frontend/issues/697) New Businesspartner modal overlay cancel
    * Including the cancel button in modal overlay of new Business Partner window.
  * [#700](https://github.com/metasfresh/metasfresh-webui-frontend/issues/700) Typeahead not working in lookup filter parameters
    * Fixing typahead fields/ dropdowns in process parameters, that were not working.
  * [#701](https://github.com/metasfresh/metasfresh-webui-frontend/issues/701) "Filter" panel does not disappear
    * Fixing a Bug that prohibited to close Filter panels without filling mandatory fields.
  * [#702](https://github.com/metasfresh/metasfresh-webui-frontend/issues/702) Running a process from menu does not work, again
    * Fixes the Process Panel issue when a Processes is started from menu. Now the panel is shown again.
  * [#703](https://github.com/metasfresh/metasfresh-webui-frontend/issues/703) leave the page message on request modal
    * Now its possible again to leave a fully recorded request modal overlay without receiving a question about saving.
  * [#704](https://github.com/metasfresh/metasfresh-webui-frontend/issues/704) request modal saving is loading 4 tabs
    * Internal issue fixed, when saving the request modal overlay, loading multiple tabs.


# metasfresh 5.7 (2017-17)

## Features

* metasfresh-backend
  * [#427](https://github.com/metasfresh/metasfresh/issues/427) Integrate spring DI with metasfresh Services helper class
    * Now integrated Sprint Dependancy Injection into metasfresh Services.
  * [#880](https://github.com/metasfresh/metasfresh/issues/880) Improve IProcessPrecondition framework
    * Improvements on Process Framework and issue handling.
  * [#1211](https://github.com/metasfresh/metasfresh/issues/1211) Preparation Time: Change to first possible on same Day as Promised Date-Time
    * Adjustment of the Tour Planning Preparation Date calculation. Now taking the earliest Tour preparation time according to the date promised.
  * [#1300](https://github.com/metasfresh/metasfresh/issues/1300) Bank Statement Window in WebUI
    * Adding the initial window layout for Bankstatement window in webUI.
  * [#1322](https://github.com/metasfresh/metasfresh/issues/1382) Make Packing Item editable in Manufacturing Order Header
    * Making the Field Packing Item editable in Manufacturing Order header.
  * [#1347](https://github.com/metasfresh/metasfresh/issues/1347) technical: ModelClassGenerator shall generate BigDecimal.ZERO instead of Env.ZERO
  * [#1349](https://github.com/metasfresh/metasfresh/issues/1349) Create Product category webui window
    * Adding the product category window to WebUI.
  * [#1351](https://github.com/metasfresh/metasfresh/issues/1351) IsTransferWhenNull not working correctly anymore
    * Attributes which have IsTransferWhenNull=Y are now also transferred during propagation to the received product in manufacturing.
  * [#1355](https://github.com/metasfresh/metasfresh/issues/1355) Allow Business Partner group without setting price system
    * The creation of Business Partner Groups are now possible without mandatory Pricing System.
  * [#1358](https://github.com/metasfresh/metasfresh/issues/1358) Drop de.metas.order.callout.CheckDouble
  * [#1360](https://github.com/metasfresh/metasfresh/issues/1360) Translating processes and windows for order to shipment process to en_US
    * Adding the Translation of en_US for the order to shipment workflow.
  * [#1366](https://github.com/metasfresh/metasfresh/issues/1366) Fields missing in Sales Order WebUI for advanced Edit
    * Adding missing fields into advanced edit of Sales Order Window in WebUI.
  * [#1370](https://github.com/metasfresh/metasfresh/issues/1370) Make request type names translatable
    * Translated the Request Names into Language en_US.
  * [#1382](https://github.com/metasfresh/metasfresh/issues/1382) Make Packing Item editable in Manufacturing Order Header
    * Allowing to edit the Packing Instruction in Manufacturing Order.
  * [#1393](https://github.com/metasfresh/metasfresh/issues/1393) Translate New Partner Quick Input window to en_US
    * Translating the Quickentry for new Business Partners to en_US Language.
  * [#1395](https://github.com/metasfresh/metasfresh/issues/1395) Translate Payment Terms to en_US
    * Adding the Translation for Payment Terms of language en_US.

* metasfresh-webui-api
  * [#261](https://github.com/metasfresh/metasfresh-webui-api/issues/261) Date offset in Dashboard KPI because of missing Timezone
    * Adjustment of Dashboard KPI, now ofsetting the Date because of missing Timezone.
  * [#291](https://github.com/metasfresh/metasfresh-webui-api/issues/291) Show value/ name in breadcrumb but edit in window
    * Adjusting the look and feel of the breadcrumb structure and navigation.
  * [#300](https://github.com/metasfresh/metasfresh-webui-api/issues/300) Quickaction new Request in BPartner Window
    * New Functionality to quickly add a quickaction for request creation to WebUI windows.
  * [#313](https://github.com/metasfresh/metasfresh-webui-api/issues/313) Handling Unit Barcode selection 1:1
    * Adding the 1:1 selection functionality to Barcode scanning and Handling Unit selection.
  * [#314](https://github.com/metasfresh/metasfresh-webui-api/issues/314) HU attributes shall be readonly if the HUStatus is not planning
    * Handling Unit attributes are editable as long as the Handling Unit status is 'planning'.
  * [#315](https://github.com/metasfresh/metasfresh-webui-api/issues/315) Manufacturing Issue/Receipt: merge BOM Type and HU Type columns
    * Merging the Handling Unit Type and BOM Type on HU Level and Issue/ Receipt Lines to 1 column called Type.
  * [#316](https://github.com/metasfresh/metasfresh-webui-api/issues/316) Implement password widgetType support
    * Adding support for password widget type in Rest-API, preparing the frontend implementation.
  * [#317](https://github.com/metasfresh/metasfresh-webui-api/issues/317) Manufacturing Issue/Receipt: drop StatusInfo column
    * Adjustment in Manufacturing Issue and receipt, drpping the status info column in WebUI.
  * [#318](https://github.com/metasfresh/metasfresh-webui-api/issues/318) Manufacturing Issue/Receipt: show packing info for BOM components
    * Adding the Packaging Info Action Issue & Receipt Editor in new Manufacturing.
  * [#319](https://github.com/metasfresh/metasfresh-webui-api/issues/319) Manufacturing Issue/Receipt: show BOM line attributes if any
    * Adding BOM line Attributes to manufacturing Order WebUI.
  * [#321](https://github.com/metasfresh/metasfresh-webui-api/issues/321) Manufacturing Issue/Receipt: introduce planning status
    * Introducing the planning status to manufacturing Order WebUI.
  * [#322](https://github.com/metasfresh/metasfresh-webui-api/issues/322) Manufacturing Issue/Receipt: Fix Qty and QtyPlan columns
    * Adding Fix Qty and Qty Plan to manufacturing Order WebUI.
  * [#323](https://github.com/metasfresh/metasfresh-webui-api/issues/323) Manufacturing Issue/Receipt: receipt lines shall be displayed first
    * Reordering the manufacturing order ui, now ordered by receipt lines first.
  * [#326](https://github.com/metasfresh/metasfresh-webui-api/issues/326) technical: Remove JSONProcessInstanceResult deprecated properties
    * Technical issue for further improvement of JSON Messaging in Rest-API.
  * [#332](https://github.com/metasfresh/metasfresh-webui-api/issues/332) Empties window without pre-selection possible
    * Adding a new Functioanlity to allow empties receive without having preselected material receipt lines.

* metasfresh-webui-frontend
  * [#248](https://github.com/metasfresh/metasfresh-webui-frontend/issues/248) Handle Password Fields in WebUI
    * New widget for Password Handling in WebUI.
  * [#411](https://github.com/metasfresh/metasfresh-webui-frontend/issues/411) Make the parameter names visible in filters
    * Improvement in Process Parameter dropdown, now allowing to define the Parameter layout with primary/ secondary indicator.
  * [#537](https://github.com/metasfresh/metasfresh-webui-frontend/issues/537) KPI: implement a non intrusive way to display KPI related errors
    * Improvement for the KPI error Handling.
  * [#649](https://github.com/metasfresh/metasfresh-webui-frontend/issues/649) windowId shall be handled as a string and not as a number
    * Changing the format of window ID, now representing as string and not numbers.
  * [#666](https://github.com/metasfresh/metasfresh-webui-frontend/issues/666) refresh in attachments side list
    * Now refreshing the sidelist and showing the attached files after new attachments to a record.
  * [#667](https://github.com/metasfresh/metasfresh-webui-frontend/issues/667) Change /rest/api/pattribute request message
    * Internal improvement of the Rest-API request message.
  * [#676](https://github.com/metasfresh/metasfresh-webui-frontend/issues/676) Process result: implement openDocument as modal
    * New functionality for the openDocument Implementation, now allowing the modal overlay usage.
  * [#678](https://github.com/metasfresh/metasfresh-webui-frontend/issues/678) Get rid of deprecated static docNo input in header.
    * Housekeeping issue, getting rid of deprecated document No Field.
  * [#683](https://github.com/metasfresh/metasfresh-webui-frontend/issues/683) Tooltip on first level breadcrumb
    * New Tooltip on first level breadcrumb.
  * [#695](https://github.com/metasfresh/metasfresh-webui-frontend/issues/695) Larger photo preview screen/ modal overlay
    * Resizing the preview image in material receipt, allowing to preview in modal full width.
  * [#682](https://github.com/metasfresh/metasfresh-webui-frontend/issues/682) Sidelist opening shall automatically have the first line selected
    * When opening the sidelist, the first line is now automatically preselected, so the user can use arrow down directly to navigate.

* other
  * [metasfresh/metasfresh-dist-orgs#8](https://github.com/metasfresh/metasfresh-dist-orgs/issues/8) add trainings management
    * Adding Traning Management window, tab and field changes to metasfresh.

## Fixes

* metasfresh-backend
  * [#1343](https://github.com/metasfresh/metasfresh/issues/1343) Cannot reverse documents
    * Fixing the bug that prevented the usage of document reversals.
  * [#1346](https://github.com/metasfresh/metasfresh/issues/1346) Cannot "LU zuteilen" (Swing HU Editor)
    * Fixes a Bug that did not allow to add split-off Transport Units to be added to a new Logistic Unit.
  * [#1378](https://github.com/metasfresh/metasfresh/issues/1378) Packing item not displayed in receipt jasper if none was ordered
    * Decoupling the Packing Instructions in Material Receipt from orderline Packing Instructions.
  * [#1379](https://github.com/metasfresh/metasfresh/issues/1379) Problem creating FK reference on DLM'ed table
    * Fixing a issue when creating foreign key constraints on tables which are referenced to data lifecyle mangement.
  * [#1387](https://github.com/metasfresh/metasfresh/issues/1387) Permission Tabs not displayed in window Role
    * Adding the permission Tabs to window Role in webUI.
  * [#1388](https://github.com/metasfresh/metasfresh/issues/1388) HU from Cost Collector is locked and cannot be selected anymore after the CC was reversed
    * After reversing a Cost Collerctor the referenced HU is now not locked anymore.
  * [#1348](https://github.com/metasfresh/metasfresh/issues/1348) M_ShipmentSchedule_EnqueueSelection ignores role's org access

* metasfesh-webui-api
  * [#151](https://github.com/metasfresh/metasfresh-webui-api/issues/151) grid view websocket notifications: fullyChanged shall not be set when changedIds is set
    * Internal websocket improvement for grid view handling.
  * [#267](https://github.com/metasfresh/metasfresh-webui-api/issues/267) Show an error or message for user when printing not possible bc of missing config
    * Now showing an eror message to the user when printing is not possible.
  * [#268](https://github.com/metasfresh/metasfresh-webui-api/issues/268) HU attributes shall always provide the WidgetType along with the data/changes
    * WebUI Improvement of Handling Unit Attributes Widget.
  * [#270](https://github.com/metasfresh/metasfresh-webui-api/issues/270) cannot add trading unit with batch entry after using add new
    * Fix for Sales Order Batch entry in WebUI, now also allowing to add Trade Unit Packing Material after adding via "add new".
  * [#306](https://github.com/metasfresh/metasfresh-webui-api/issues/306) Address missing in 'Adresse' for bpartner created on-the-fly
    * Fix for quickentry of Business Partner and Locations via Sales Order now also adding the location name.
  * [#310](https://github.com/metasfresh/metasfresh-webui-api/issues/310) Switching language does not translate document references
    * Fix for the new Language change switch. Now also translating document references in WebUI.
  * [#311](https://github.com/metasfresh/metasfresh-webui-api/issues/311) Switching language does not translate document lookup values
    * Fix for the new Language change switch. Now also translating document lookup values in WebUI.
  * [#328](https://github.com/metasfresh/metasfresh-webui-api/issues/328) Manufacturing receipt mandatory Field not filled
    * Fix for manufacturing action_receipt. Now filling all mandatory fields.
  * [#324](https://github.com/metasfresh/metasfresh-webui-api/issues/324) File Size Limit
    * Raising the file size limit for uploading attachments to webUI.
  * [#329](https://github.com/metasfresh/metasfresh-webui-api/issues/329) Issue HU 404 not found
    * Fixing a 404 Page not found Bug when trying to issue product 2 times.

* metasfresh-webui-frontend
  * [#433](https://github.com/metasfresh/metasfresh-webui-frontend/issues/433) ShipmentSchedule: Only displayed after "No data" showing up
    * Eliminating the "No data" page when loading correctly. It should only be displayed if there actually is no data.
  * [#551](https://github.com/metasfresh/metasfresh-webui-frontend/issues/551) Error when recording Swiss location in webUI
    * Fixing a Bug when recording new locations via Business Partner Quick Input.
  * [#567](https://github.com/metasfresh/metasfresh-webui-frontend/issues/567) Date attribute is not correctly rendered
    * Fixes the rendering of the Date attribute Field.
  * [#579](https://github.com/metasfresh/metasfresh-webui-frontend/issues/579) DocumentNo field is not updated
    * Fixes the creation of new Business Partner search values.
  * [#596](https://github.com/metasfresh/metasfresh-webui-frontend/issues/596) red line appears on document only after refresh
    * Fixes the behavior of the save indicator. Now showing the Red save eroror indicators also whithout need to refresh.
  * [#641](https://github.com/metasfresh/metasfresh-webui-frontend/issues/641) Shortcuts behavior sometimes weird
    * Fixes a weird behavior of shortcut usage and navigation in WebUI action bar menues.
  * [#644](https://github.com/metasfresh/metasfresh-webui-frontend/issues/644) Creating a new Discount record error
    * Fixes a Bug when creating a new Discount.
  * [#664](https://github.com/metasfresh/metasfresh-webui-frontend/issues/664) process doesn't open directly
    * Fixing a weird behavior when opening processes, only worked when pressing something else in menu after first try.
  * [#672](https://github.com/metasfresh/metasfresh-webui-frontend/issues/672) Process error not displayed
    * Now responding errors to the user when trying to start a process without filling all mandatory fields.
  * [#673](https://github.com/metasfresh/metasfresh-webui-frontend/issues/673) Wrong report file endpoint is called for processes which are started from main menu
    * Fixes a Bug that opens a printing preview report pdf with the completely wrong URL.
  * [#680](https://github.com/metasfresh/metasfresh-webui-frontend/issues/680) Navigation breadcrumb vs. Navigation Menu
    * Unifying the behavior between opening windows via Breadcrumb menue and Navigation menue.
  * [#685](https://github.com/metasfresh/metasfresh-webui-frontend/issues/685) Cannot open manufacturing modal overlay anymore
    * Fixing a Bug that disallowed the opening of manufacturing modal overlay.
  * [#688](https://github.com/metasfresh/metasfresh-webui-frontend/issues/688) Main page /dashboard is broken
    * Fixes the main Page/ Dashboard layout.
  * [#689](https://github.com/metasfresh/metasfresh-webui-frontend/issues/689) Image widget is missing right border
    * Adding the right border to image widget.


* other
  * [#7](https://github.com/metasfresh/metasfresh-dist/issues/7) metasfresh-dist parent pom.xml's artifact name shall be metasfresh-dist
    * Now making sure that by default, the project is imported (into eclipse) as "metasfresh-dist" that name is used in some .launch files, e.g. the one to start the swing client.
  * [#6](https://github.com/metasfresh/metasfresh-parent/issues/6) still using metasfresh-snapshots repo
    * Eliminating the dependancy to metasfresh-snapshots repo.

# metasfresh 5.6 (2017-16)

## Features

* metasfresh-backend
  * [#1062](https://github.com/metasfresh/metasfresh/issues/1062) Return HU to vendor
    * New Functionality to send received Material back to Vendor via HU Editor. Can be automatically filtered directly via correction functionality in Material Receipt POS or manually filtered  in Handling Unit Editor.
  * [#1064](https://github.com/metasfresh/metasfresh/issues/1064) Move HU to garbage
    * Implementation of the Handling Unit Material disposal functionality as part of the RMA workflow.
  * [#1065](https://github.com/metasfresh/metasfresh/issues/1065) Move HU to other Warehouse/ Locator
    * New functionality to easy move Handling Units from the current Locator to a new selected Locator.
  * [#1223](https://github.com/metasfresh/metasfresh/issues/1223) Show line number in jaspers
    * Now showing the line No in all Jasper Documents - order, inout, invoice - for sales and purchase.
  * [#1286](https://github.com/metasfresh/metasfresh/issues/1286) Performance Business Partner Pricelist generation process
    * Improving the performance of the BusinessPartner Pricelist generation process. The time for the report generation is reduced by aprox 60%.
  * [#1322](https://github.com/metasfresh/metasfresh/issues/1322) Forecast Window in WebUI
    * Adding the initial Layout of the Forecast Window to WebUI.

* metasfresh-webui-api
  * [#269](https://github.com/metasfresh/metasfresh-webui-api/issues/269) API for Manufacturing UI Planning/ Doing
    * Implemention of new manufacturing window and Functionalities (issue, receipt) in WebUI. Refactoring of current backend logic to serve the Rest-API.

* metasfresh-webui-frontend
  * [#96](https://github.com/metasfresh/metasfresh-webui-frontend/issues/96) Actions overlay menu cleanup
    * Housekeeping task. Tidying the action menu and removing the actions that are not attached to working procedures.
  * [#355](https://github.com/metasfresh/metasfresh-webui-frontend/issues/355) view websocket notifications: handle "changedIds"
    * Adding internal functionality to react on websocket information about changed Element ID's
  * [#608](https://github.com/metasfresh/metasfresh-webui-frontend/issues/608) Chart animations
    * Adding animation to dashboard charts (pie and bar charts).
  * [#630](https://github.com/metasfresh/metasfresh-webui-frontend/issues/630) Open docLists side by side in QuickAction response.
    * New frontend functionality to open Document Lists side-by-side at the same time.
  * [#643](https://github.com/metasfresh/metasfresh-webui-frontend/issues/643) Reduce size of Action Menu
    * Reducing the side of action menu. Now that the attachments and referenced documents have been moved to sidelist, the action menue does not need the large size anymore.
  * [#651](https://github.com/metasfresh/metasfresh-webui-frontend/issues/651) 404 errors for non-existing pages
    * Implemetation of 404-page for not existing window elements.
  * [#653](https://github.com/metasfresh/metasfresh-webui-frontend/issues/653) Honor openIncludedView's viewType property
    * New feature viewType to tell the frontend to open the viewID in the requested viewType. This allows the opening of viewID's also in other Types than GridView.
  * [#655](https://github.com/metasfresh/metasfresh-webui-frontend/issues/655) Handle process layout type field
    * New modal overlay type for processes. This is firt time needed for scan control prcess view.

## Fixes
* metasfresh-backend
  * [#1191](https://github.com/metasfresh/metasfresh/issues/1191) small adjustments in jasper documents
    * fix empty page in sales invoice document
  * [#1264](https://github.com/metasfresh/metasfresh/issues/1264) Material Receipt document best before date missing
    * Fixes the best-before-date issues in Material Receipt documents.
  * [#1343](https://github.com/metasfresh/metasfresh/issues/1343) Cannot reverse documents
    * Fixes a Bug that did not allow the reversal of Documents.
  * [#1346](https://github.com/metasfresh/metasfresh/issues/1346) Cannot "LU zuteilen" (Swing HU Editor)
    * Fixes a Bug that did not allow to allocate more than one selected Handling Unit after split to an existing Logistic Unit.
  * [#1351](https://github.com/metasfresh/metasfresh/issues/1351) IsTransferWhenNull not working correctly anymore
    * Fixing an issue in attribute transfer. The flag isTransferWhenNull was not considered properly.
  * [#1636](https://github.com/metasfresh/metasfresh/issues/1336) npe in purchase order
    * Fixing a Null Pointer Exception in Purchase Order when using Drop Shipment.

* metasfresh-webui-api
  * [#303](https://github.com/metasfresh/metasfresh-webui-api/issues/303) ASI button not working from process panel
    * This fix allows to to open the Attribute Panel as Process Panel.

* metasfresh-webui-frontend
  * [#645](https://github.com/metasfresh/metasfresh-webui-frontend/issues/645) HOME/END keys not working in process parameter field when opened from view
    * The HOME and END Buttons now also work in process Parameter fields.
  * [#656](https://github.com/metasfresh/metasfresh-webui-frontend/issues/656) Selected grid row and quick actions not consistent after closing a modal
    * Returning to the main view after closing modal overlay process parameters now preserves the previously selected grid row.
  * [#657](https://github.com/metasfresh/metasfresh-webui-frontend/issues/657) Manufacturing Order Issue/Receipt is not displaying the attributes
    * Manufacturing project. Now the grid view lines also display attributes if available for the corresponding line.
  * [#659](https://github.com/metasfresh/metasfresh-webui-frontend/issues/659) Double-clicking on included view row shall not open the document
    * Manufacturing project. The double click on a selected line now does not open the underlying document anymore.
  * [#661](https://github.com/metasfresh/metasfresh-webui-frontend/issues/661) Service not available not detected on login
    * The login menu now shows an overly with "Service not available" if this is the case.

# metasfresh 5.5 (2017-15)

## Features
* metasfresh-backend
  * [#695](https://github.com/metasfresh/metasfresh/issues/695) swingUI provide lib-dirs to access user jars and dlls at runtime
    * Adding a possibility to provide user jars and dlls at runtime for swing client, thanks to @homebeaver
  * [#992](https://github.com/metasfresh/metasfresh/issues/992) Allow subscription without shipment
    * Allowing to use subsriptions for services that are not "shipped" and therfor will not be shown in shipment schedule.
  * [#1057](https://github.com/metasfresh/metasfresh/issues/1057) Role window WebUI
    * Initial Layout configuration for Role maintenance Window.
  * [#1287](https://github.com/metasfresh/metasfresh/issues/1287) Search for name in product window in webUI
    * Now it's possible to search and filter by product name in product window in WebUI.
  * [#1291](https://github.com/metasfresh/metasfresh/issues/1291) Manufacturing Order Window adjustments
    * Adding further adjustments to new manufacturing order in WebUI, allowing an easier/ better user experience.
  * [#1301](https://github.com/metasfresh/metasfresh/issues/1301) DeliveryDays Window for WebUI
    * Adding the window layout for delivery days in WebUI.
  * [#1302](https://github.com/metasfresh/metasfresh/issues/1302) Tour Window in WebUI
    * Adding the tour maintenance window in new WebUI.
  * [#1303](https://github.com/metasfresh/metasfresh/issues/1303) Tour Version Window in WebUI
    * Adding the new window tour version to WebUI, allowing tour maintenance for businesspartner, locations and delivery days.
  * [#1307](https://github.com/metasfresh/metasfresh/issues/1307) Only show Partner Name fields needed for case company
    * Now switching between company name field and person name field depending on isCompany flag in window businesspartner in WebUI.
  * [#1309](https://github.com/metasfresh/metasfresh/issues/1309) Unit of Measure Window in WebUI
    * Adding the initial window setup for unit of measure window in WebUI.
  * [#1324](https://github.com/metasfresh/metasfresh/issues/1324) Take out pwd Field from AD_User in WebUI
    * Not showing the pwd field anymore un user window WebUI.

* metasfresh-webui-api
  * [#294](https://github.com/metasfresh/metasfresh-webui-api/issues/294) Refactor /process/start response
    * Massive technical improvement about processes and documents in metasfresh. This refactoring was needed to meet new requirements in WebUI in a better way.

* metasfresh-webui-frontend
  * [#88](https://github.com/metasfresh/metasfresh-webui-frontend/issues/88) Special Place for Record dependent content
    * Record dependant content and references are now moved from action menu to the extended sidelist menu. Each reference area has its own keyboard shortcut so that navigation to that content is easy and fast.
  * [#110](https://github.com/metasfresh/metasfresh-webui-frontend/issues/110) Don't fetch the side list when it's not needed
    * Performance improvement. Only fetching the sidelist initially when the user opens it first time.
  * [#267](https://github.com/metasfresh/metasfresh-webui-frontend/issues/267) Sidelist refactor
    * Refactoring of sidelist, now including other document references (zoom accross, record attachements)
  * [#628](https://github.com/metasfresh/metasfresh-webui-frontend/issues/628) frontend: refactor /process/start response
    * Frontend work for the refactoring of processes and documents in metasfresh.
  * [#631](https://github.com/metasfresh/metasfresh-webui-frontend/issues/631) Minor grid view layout tweaks
    * Minor UX improvements/ prettyfying to grid view in WebUI.
  * [#636](https://github.com/metasfresh/metasfresh-webui-frontend/issues/636) Sidelist Fontsize too small
    * Raising the font size in sidelist to match the fontsize in other menues.

## Fixes
* metasfresh-backend
  * [#886](https://github.com/metasfresh/metasfresh/issues/886) GrandTotal missing in GridView of Purchase Order
    * Adding column grandtotal to gridview of purchase orders in WebUI.
  * [#1241](https://github.com/metasfresh/metasfresh/issues/1241) metasfresh does not notify procurement-webui about new contracts
    * Fix for procurement WebUI when automatically prolonging new procurement contracts.
  * [#1294](https://github.com/metasfresh/metasfresh/issues/1294) Report with Attribute Set Parameter cannot be started anymore
    * Fixing an exception when calling the attribute editor in process parameters.
  * [#1318](https://github.com/metasfresh/metasfresh/issues/1318) Exception when creating translation entries for new System Language
    * Fixing an exception which popped up when adding a new system language.

* metasfresh-webui-frontend
  * [#619](https://github.com/metasfresh/metasfresh-webui-frontend/issues/619) Address editor silently ignores changes if the mandatory fields are not filled
    * Usability fix for the location editor in WebUI. Improvement of user interaction possibility when mandatory fields are not filled in location editor.
  * [#620](https://github.com/metasfresh/metasfresh-webui-frontend/issues/620) When deleting a newly created document, frontend shall not ask the user if the user wants to leave the page
    * Usability fix. After deleting a document the user is now not asked anymore if the page shall be left altough it does not exist anymore, because deleted.
  * [#637](https://github.com/metasfresh/metasfresh-webui-frontend/issues/637) CTRL+1 and keyboard navigation left-right not working anymore
    * Fix for action menu (ctrl+1) for keyboard arrow navigation.
  * [#639](https://github.com/metasfresh/metasfresh-webui-frontend/issues/639) Navigation shortcut ctrl+2 is broken
    * Fixing the shortcut for navigation menu.

# metasfresh 5.4 (2017-14)

## Features
* metasfresh-backend
  * [#741](https://github.com/metasfresh/metasfresh/issues/741) packing material product category config
    * New functionality to be able to define the package material category per organisational unit, so that jasper reports can do the package material groupings because of that.
  * [#995](https://github.com/metasfresh/metasfresh/issues/995) Translation en_US for Material Receipt Candidates Window
    * Adding the initial set of Translation en_US to the material Receipt Candidates Window in WebUI.
  * [#1181](https://github.com/metasfresh/metasfresh/issues/1181) Refine Layout for Attribute Window in WebUI
    * Adding the initial Layout for the Attribute Window in WebUI.
  * [#1182](https://github.com/metasfresh/metasfresh/issues/1182) Create Layout for User Window in WebUI
    * Adding the initial Layout for the User window into WebUI.
  * [#1185](https://github.com/metasfresh/metasfresh/issues/1185) Initial Layout for vendor Invoices in WebUI
    * Adding the initial Layout for vendor Invoice Window in WebUI.
  * [#1169](https://github.com/metasfresh/metasfresh/issues/1169) Prevent C_Flatrate_Terms with overlapping dates
  * [#1205](https://github.com/metasfresh/metasfresh/issues/1205) Provide Default KPI Config
    * Prepared a default KPI Configuration to show an example Dashboard based on elasticsearch and with KPI done with D3JS on the entry screen of metasfresh after login.
  * [#1206](https://github.com/metasfresh/metasfresh/issues/1206) Remove Gebinderückgabe from Shipment Note for mf15 endcustomer
    * Removing the Text for "empties return" in Shipment Documents for default Jasper Docuiment. The Text does not make sense for companies that don't use the empties management functionality.
  * [#1222](https://github.com/metasfresh/metasfresh/issues/1222) Show orderline description only in the first column of the Jasper
    * Enhanced Reports definition, so that orderline desciptions are only shown in the first column, and not overlaying the others anymore.
  * [#1224](https://github.com/metasfresh/metasfresh/issues/1224) hide HU related data where is not used
  * [#1228](https://github.com/metasfresh/metasfresh/issues/1228) create translate properties for footer report
    * New properties file for the footer subreport for Jasper documents. Now allowing to add translations for that.
  * [#1247](https://github.com/metasfresh/metasfresh/issues/1247) Don't try to create empties movements if empties warehouse same as current warehouse
    * Now not creating movements anymore if the source and target warehouse of empty movements are identical.
  * [#1249](https://github.com/metasfresh/metasfresh/issues/1249) Initial Layout for Material Movement Window WebUI
    * Adding the initial Windows Layout for material movements in WebUI.
  * [#1264](https://github.com/metasfresh/metasfresh/issues/1264) Material Receipt document "old" best before date missing
  * [#1268](https://github.com/metasfresh/metasfresh/issues/1268) Do not print label automatically by default on material receipt
    * Switching off the automatic label printing in material receipt for default configurations.
  * [#1277](https://github.com/metasfresh/metasfresh/issues/1277) Migrate current WebUI Menu from Development to master
    * Migration script for the currents metasfresh webUI menu tree, now showing the new windows.
  * [#1282](https://github.com/metasfresh/metasfresh/issues/1282) Exception splitting aggregate HU with UOM that has no UOMType

* metasfresh-webui-api
  * [#286](https://github.com/metasfresh/metasfresh-webui-api/issues/286) UserSession language endpoint shall always work with JSON values

* metasfresh-webui-frontend  
  * [#541](https://github.com/metasfresh/metasfresh-webui-frontend/issues/541) Hide new and delete included documents when they are not available.
    * New Functionality to show/ not show the new and delete buttons on included tabs/ subtabs if not available.
  * [#587](https://github.com/metasfresh/metasfresh-webui-frontend/issues/587) Language Switcher for WebUI
  * [#604](https://github.com/metasfresh/metasfresh-webui-frontend/issues/604) Mandatory lookup fields are not marked as error
  * [#605](https://github.com/metasfresh/metasfresh-webui-frontend/issues/605) When opening a process panel, the first field shall be focus by default
  * [#614](https://github.com/metasfresh/metasfresh-webui-frontend/issues/614) When the language is switched widgets shall be invalidated/refreshed

## Fixes
* metasfresh-backend
  * [#1191](https://github.com/metasfresh/metasfresh/issues/1191) small adjustments in jasper documents
    * Adding a few detailed adjustments to the default metasfresh documents layout, especially for cases when generating documents with many lines.
  * [#1222](https://github.com/metasfresh/metasfresh/issues/1222) Show orderline description only in the first column of the Jasper
    * Adjustment of the document line description field now defining boundaries for the field content on the generated Jasper Documents making the content better readable.
  * [#1225](https://github.com/metasfresh/metasfresh/issues/1225) Drop legacy jasper sql logic
    * Maintainance of Jasper Document SQL. Removing legace SQL that's not needed anymore.
  * [#1240](https://github.com/metasfresh/metasfresh/issues/1240) Number-of-copies parameter is ignored in direct print
    * Fixes the document printing copies configuration. The number of copies parameter is now also considered in direct print.
  * [#1244](https://github.com/metasfresh/metasfresh/issues/1244) Shipment Schedule's QtyDeliveredTU is not updated correctly
    * Fixed a minor bug that prevented the update of the QtyDelivered TU Field in Shipment schdules.
  * [#1248](https://github.com/metasfresh/metasfresh/issues/1248) Empties movements are not generated from empties shipment/receipt
    * Fixing a bug that did not create movements for empties receive documents after completion.
  * [#1256](https://github.com/metasfresh/metasfresh/issues/1256) Database tables are created in wrong schema
    * Fixes a Bug that created db tables in wrong schema. Now the tables are created in public schema again.
  * [#1260](https://github.com/metasfresh/metasfresh/issues/1260) DocumentNo not generated for manual invoices in WebUI
    * Adding a minor fix to the customer Invoice Window in WebUI, that prevented the creation of manual Invoices for customers.
  * [#1263](https://github.com/metasfresh/metasfresh/issues/1263) ITrxListener.afterCommit is fired twice with TrxPropagation.REQUIRES_NEW
    * Fixes the double tap of ITrxListener.afterCommit.
  * [#1267](https://github.com/metasfresh/metasfresh/issues/1267) Cannot open ASI editor in Swing
    * The Attrubute Set Instance Widget could not be opened in Swing Client anymore. This Bugfix now enables that again.
  * [#1272](https://github.com/metasfresh/metasfresh/issues/1272) Vendor ADR configuration not initially considered in Orderline
    * Fixing a Bug that prevented the default settings of vendor attributes in orderline.
  * [#1274](https://github.com/metasfresh/metasfresh/issues/1274) webui - allow using the session's remote host name or IP as hostkey
    * New feature that allows to use the sessions host name or IP Address as hostkey for printing rounting and configuration.
  * [#1282](https://github.com/metasfresh/metasfresh/issues/1282) Exception splitting aggregate HU with UOM that has no UOMType
    * Fixes a Bug in Splitting HU action. Now also allowing splitting action with compressed Handling Units that don't have a Unit of measure Type.

* metasfresh-webui-api
  * [#277](https://github.com/metasfresh/metasfresh-webui-api/issues/277) Don't export JSONDocument.fields if empty
    * Fixes a Bug that exported empty JSON Document Fields
  * [#283](https://github.com/metasfresh/metasfresh-webui-api/issues/283) Build does not use the specified parent version
    * Fix for maven/ build system to fetch the specified parent version for build.
  * [#284](https://github.com/metasfresh/metasfresh-webui-api/issues/284) HU editor: Cannot receive stand alone TUs by default
    * Now also standalone Transport Units can be received and processed in Material Receipt.
  * [#287](https://github.com/metasfresh/metasfresh-webui-api/issues/287) Update current notifications when user language was changed
  * [#289](https://github.com/metasfresh/metasfresh-webui-api/issues/289) New/Delete buttons missing when a document was initially loaded
    * Now showing the New and Delete Buttons in Subtabs/ included Tabs, when initially loaded.

* metasfresh-webui-frontend
  * [#594](https://github.com/metasfresh/metasfresh-webui-frontend/issues/594) inform users that only Chrome is currently supported on login screen
    * The current development for metasfresh WebUI ist done optimized for Chrome browser. Now informing the user about that on login screen, if trying to login with other browser.
  * [#595](https://github.com/metasfresh/metasfresh-webui-frontend/issues/595) kpi disappears when minimize
    * Fixing a Bug that vanished the KPI widgets after minimizing action.
  * [#597](https://github.com/metasfresh/metasfresh-webui-frontend/issues/597) cancel on "Do you really want to leave?" sends you 2 steps back
    * Fix for the leave confirmation popup. Now only going back 1 step after confiormation.
  * [#599](https://github.com/metasfresh/metasfresh-webui-frontend/issues/599) Action button remains gray if the process execution fails
  * [#609](https://github.com/metasfresh/metasfresh-webui-frontend/issues/609) Included subtab height 100% broken again
    * Fix for the 100% height Layout of windows with included Tab. Subtab Shall always expand to 100% of screen resolution height until available spave is used. After that exceeding page size.
  * [#616](https://github.com/metasfresh/metasfresh-webui-frontend/issues/616) delete option missing after add new
    * The delete Button is now available again after starting the add new action.
  * [#618](https://github.com/metasfresh/metasfresh-webui-frontend/issues/618) Done button is not responding

# metasfresh 5.3 (2017-13)

## Important Changes
* metasfresh-backend
  * [#1199](https://github.com/metasfresh/metasfresh/issues/1199) user credentials of "SuperUser" are renamed to metasfresh
    * Changing the default login credentials to the vanilla system to metasfresh/ metasfresh.

## Features
* metasfresh-backend
  * [#1197](https://github.com/metasfresh/metasfresh/issues/1197) Introduce AdempiereException setParameter/getParameters
    * Introducing getter and setter for Parameters in ADempiereException.
  * [#1201](https://github.com/metasfresh/metasfresh/issues/1201) Add Manufacturing Order Window for WebUI
    * Adding a new window to webUI for Manufacturing Order. This is the first step in the new Manufacuring Project introducing Manufacturing disposition and WebUI Interface. The first Milestone of the Project is planned for early June 2017.
  * [#1202](https://github.com/metasfresh/metasfresh/issues/1202) Clean up ReplicationException
    * Maintenance Task. Cleaning up the addParameter method in Replication Exception which is now available in ADempiereException and therfor deprecated.


* metasfresh-webui-api
  * [#273](https://github.com/metasfresh/metasfresh-webui-api/issues/273) remove deprecated staleTabIds
    * Adding a functionality to not show stale Tabs in WebUI.
  * [#272](https://github.com/metasfresh/metasfresh-webui-api/issues/272) Document Line Delete Behaviour
    * Adjusting the delete behavior of document lines. Now the line also visibly dissappears after delete action.
  * [#276](https://github.com/metasfresh/metasfresh-webui-api/issues/276) Cannot change BPartner address
    * Now allowing the change of BusinessPartner Locations after initial creation.

* metasfresh-webui-frontend
  * [#118](https://github.com/metasfresh/metasfresh-webui-frontend/issues/118) Copy-paste behaviour for document and lists
    * New functionality to Copy-Paste Grid view content in webUI. This was an activly used functionality in Swing User Interface now ported to the new WebUI.
  * [#442](https://github.com/metasfresh/metasfresh-webui-frontend/issues/442) Image Widget from Attachment in User Window
    * New Image widget for WebUI. Will be able to used to include images/ phots for record which are attached to a record.

## Fixes
* metasfresh-backend
  * [#1194](https://github.com/metasfresh/metasfresh/issues/1194) HU "Herkunft" HU_Attribute is not propagated from LU to VHU
    * Fix for the the propagation of attributes top-down. In this case an Attribute added to the Top-Level HU was not propagated down to the included Customer Units.
  * [#1203](https://github.com/metasfresh/metasfresh/issues/1203) Rounding of weights after split in HU Editors is not working correctly
    * Fixing the rounding of weights after Split with the new HU compression Implementation.
  * [#1237](https://github.com/metasfresh/metasfresh/issues/1237) Split fails with aggregate HUs that don't have an integer storage qty
    * Fixes a Bug that appeared when splitting HU generated with the new HU Compression functionality and dis not lead into an integer number storage quantity.

* metasfresh-webui-frontend
  * [#133](https://github.com/metasfresh/metasfresh-webui-frontend/issues/133) Notification display problem
    * Fixes a display bug in notifications created for the user after finishing asynchronous generated documents. Some documents were displayed more than once.
  * [#469](https://github.com/metasfresh/metasfresh-webui-frontend/issues/469) missing value to for range date-time filter
    * Fixes the Bug in Date Range filter widget, where the selection possibility for date-to was missing.
  * [#470](https://github.com/metasfresh/metasfresh-webui-frontend/issues/470) changing AM to PM in Date+Time fields
    * Adjustment of Date-Time Fields, fixing the wrong AP/ PM declaration.
  * [#475](https://github.com/metasfresh/metasfresh-webui-frontend/issues/475) When editing the text field in grid mode i cannot see selected text
    * Color Adjustment of selected Text. Now allowing the user to see what is selected.
  * [#593](https://github.com/metasfresh/metasfresh-webui-frontend/issues/593) DocAction bug when opening a document from references of another
    * Fixes a Bug that appeared when jumping to referenced documents without a valid docaction.

# metasfresh 5.2 (2017-12)

## Features
* metasfresh-webui-frontend
  * [#453](https://github.com/metasfresh/metasfresh-webui-frontend/issues/453) Closing modal or window with unsaved changes
    * Providing a better usability when changing the window or modal overlay with unsaved changes.
  * [#461](https://github.com/metasfresh/metasfresh-webui-frontend/issues/461) If tab layout's "supportQuickInput" is false then don't show the "Batch entry" button
    * The batch entry buttrons for quick input are now not shown when the layout provided by rest-api does not support that.
  * [#462](https://github.com/metasfresh/metasfresh-webui-frontend/issues/462) If document was not found forward to documents view
    * The User Nterface now automatically forwards to documents view in the case that a document is not found.
  * [#484](https://github.com/metasfresh/metasfresh-webui-frontend/issues/484) Login Screen 2nd Window usability
    * Improving the usability of the login screen so that the user can navigate, edit and confirm with keyboard completely without mouse usage.
  * [#491](https://github.com/metasfresh/metasfresh-webui-frontend/issues/491) Line height "jump" when editing mode
    * Improving the behavior of grid view so the lines height dows not change depending of its content.
  * [#532](https://github.com/metasfresh/metasfresh-webui-frontend/issues/532) KPI: Remove the Refresh option
    * Removing the refresh button from KPI because this is not needed anymore since D3JS implementation.
  * [#533](https://github.com/metasfresh/metasfresh-webui-frontend/issues/533) KPI: maximize/restore when double clicking on title bar
    * Improved usability on dashboard. When the user double clicks on the titlebar, then the KPI widget maximizes/ minimizes automatically.
  * [#540](https://github.com/metasfresh/metasfresh-webui-frontend/issues/540) Don't use deprecated staleTabIds
    * Improving the behavior of included tab and staled information.

* metasfresh-webui-api
  * [#252](https://github.com/metasfresh/metasfresh-webui-api/issues/252) Provide to frontend: tab allow create new and delete as they change
    * New functionalities to tab rows deleting/ adding functions. These shall only be shown in user interface if the api provides the  possibilities.
  * [#264](https://github.com/metasfresh/metasfresh-webui-api/issues/264) Support different printers for same user and different login locations
    * Additional api improvements to allow different printers for the same users with different login locations.

* metasfresh-backend
  * [#1145](https://github.com/metasfresh/metasfresh/issues/1145) Refactor adempiereJasper servlets and implement them with @RestController
    * Complete refactoring of adempiereJasper servlets so that they now can work together with the Rest API Controller.
  * [#1146](https://github.com/metasfresh/metasfresh/issues/1146) Change "sent by" in Request Notifications
    * New information in Requests, now keeping the infomration about the notification sender.
  * [#1152](https://github.com/metasfresh/metasfresh/issues/1152) Support address sequence configuration in multi org environment
    * Improvement of the country location sequence configuration in multi organisational environments.
  * [#1178](https://github.com/metasfresh/metasfresh/issues/1178) Warehouse Window in WebUI Layout
    * New Window in Web User Interface to allow the creation and maintenance of Warehouses.

## Fixes

* metasfresh-webui-frontend
  * [#451](https://github.com/metasfresh/metasfresh-webui-frontend/issues/451) Bug in Sales Order Line, Add new
    * Fixed an issue in the "add new" functionality of Sales Order Line.
  * [#474](https://github.com/metasfresh/metasfresh-webui-frontend/issues/474) Editing in the middle of a text field makes the cursor jump to the end
    * This change fixes a user experience issue that let the curson jump to the end when the user tried to edit in the middle of a text.
  * [#502](https://github.com/metasfresh/metasfresh-webui-frontend/issues/502) Lookup field layout issue when it has red border
    * Adjusting the layout of red bordered lookup elements, now aboiding that existing icons overlap the border.
  * [#526](https://github.com/metasfresh/metasfresh-webui-frontend/issues/526) Running a process from menu does not work
    * Fixing a Bug that prevented to run processes called from navigation menu.
  * [#539](https://github.com/metasfresh/metasfresh-webui-frontend/issues/539) Confirm autocomplete Field entry in grid functionality
    * Now it is possible for the user to select and confirm autocomplete entries in the grid view of included tabs.
  * [#545](https://github.com/metasfresh/metasfresh-webui-frontend/issues/545) View's windowId is not matching the expected one
    * This is fixing a Bug which mixed up the viewID's when navigating fast via browser forth and back through the screens.
  * [#547](https://github.com/metasfresh/metasfresh-webui-frontend/issues/547) Menu's first element is hidden behind on mobile
    * Fixing an issue in mobile responsive navigation design. Now also showing the first link on mobile size resolution.
  * [#550](https://github.com/metasfresh/metasfresh-webui-frontend/issues/550) Clicking on grid view breadcrumb item does not work
    * Bugfix for the breadcrumb navigaion on griwd view items.
  * [#558](https://github.com/metasfresh/metasfresh-webui-frontend/issues/558) Respect saveStatus in connected modal
    * Fixing a Bug to repect the saveStatus also in connected modal overlays.
  * [#561](https://github.com/metasfresh/metasfresh-webui-frontend/issues/561) KPI Pie Chart on Start defect

* metasfresh-webui-api
  * [#256](https://github.com/metasfresh/metasfresh-webui-api/issues/256) Cannot create a new BPartner contact
    * Bugfix for the creation of a business partner contact in Web UI.
  * [#259](https://github.com/metasfresh/metasfresh-webui-api/issues/259) New Warehouse is not saveable
    * Bugfix for the creation of a new warehouses in Web UI.
  * [#260](https://github.com/metasfresh/metasfresh-webui-api/issues/260) cannot create receipt with multiple TU on LU
    * Fix for the Material Receipt that did not properly generate receipt lines whan receiving Handling Units with Transprot Units on Load Units.
  * [#263](https://github.com/metasfresh/metasfresh-webui-api/issues/263) Bug in Warehouse window: Auftragsübersicht (intern) NPE
    * Eliminated the reason for the Null Pointer Exception in Warehouse Window for the Sales Order Overview.

* metasfresh-backend
  * [#473](https://github.com/metasfresh/metasfresh/issues/473) Adjust ESR layout for E-Druck
    * Adjusted the Layout of the swiss ESR bill for electronic exchange.
  * [#1165](https://github.com/metasfresh/metasfresh/issues/1165) QtyDelivered not set back correctly after reactivating and voiding a material receipt
    * Now correctly resetting the Qty delivered when reactivating or voiding a material receipt.
  * [#1177](https://github.com/metasfresh/metasfresh/issues/1177) Qties in Material Receipt not correct after several splitting and transforming in HU Editor
    * Handling Unit Transforming is now delivering the correct results after splitting and merging via the new Handling Unit editor and Handling Unit compression.
  * [#1184](https://github.com/metasfresh/metasfresh/issues/1184) Price is found for C_OlCand despite it was deactivated
    * Although the price was deactivated in Product Price it was used in Order Line Candidates. This is now fixed.
  * [#1192](https://github.com/metasfresh/metasfresh/issues/1192) Pricing: IsDefault was not properly migrated
    * Fixing a Bug with the product price migration after price refactoring.

# metasfresh 5.1 (2017-11)

## Features
* metasfresh-backend
  * [#1102](https://github.com/metasfresh/metasfresh/issues/1102) Field Price List Version as search Field
    * Adjusted the Fieldtype for PriceListVersion. Ist now a search field (before a direct Table drop-down). This allows the user now to do a fulltext search and autocomplete and the usage of wildcards.
  * [#1122](https://github.com/metasfresh/metasfresh/issues/1122) Reporting SQL for Products and vendor/ customer
    * New Reporting for Customer and Vendor delivered quantities for a specified Time range.
  * [#1124](https://github.com/metasfresh/metasfresh/issues/1124) metasfresh App Server start takes considerably longer
    * Improvement of Startup time for the metasfresh App server.
  * [#1134](https://github.com/metasfresh/metasfresh/issues/1134) Show Order ID in main window of Empties Receive
    * Add a new Field in Empties receive to show the Document No. of the Sales Order.
  * [#1142](https://github.com/metasfresh/metasfresh/issues/1142) Improve migration scripts handling
    * Adjustment of the Migration Scripts handling. Now saving the migration scripts in a dedicated folder called migration_scripts instead of tmp folder.
  * [#1161](https://github.com/metasfresh/metasfresh/issues/1161) Picking Terminal add Packing Material to Picking Slot takes too long
    * Large Performance Improvement of Picking processing duration when adding Packing Material to a picking Slot. This solution improves the overall performance of the picking workflow.

* metasfresh-webui-api
  * [#244](https://github.com/metasfresh/metasfresh-webui-api/issues/244) KPIs: Introduce TimeRange ending offset
    * Extended functionalitie for KPI definition. Now allowing to set an offet that is used for a ofsetted timerange dataset used for comparison in bar charts.
  * [#246](https://github.com/metasfresh/metasfresh-webui-api/issues/246) Row is not always marked as not saved
    * Extended Functionality to mark rows as saved, allowing the front-end save indicator to react on that.

* metasfresh-webui-frontend
  * [#200](https://github.com/metasfresh/metasfresh-webui-frontend/issues/200) D3JS API definition
    * Integration of D3JS into the webui frontend. D3JS is used for the generation of Barchart and Piechart KPI on the metasfresh Dashboard.
  * [#444](https://github.com/metasfresh/metasfresh-webui-frontend/issues/444) KPI Number Indicator w/ comparator
    * Implementation of the Number Indicator/ comparator widget for the Target KPI in Dashboard.
  * [#459](https://github.com/metasfresh/metasfresh-webui-frontend/issues/459) If quick input fails then don't show the quick input fields
    * Improvement of User Experience. Not showing Quick Input Fields only if these are configured in the application dictionary.

## Fixes
* metasfresh-backend
  * [#1140](https://github.com/metasfresh/metasfresh/issues/1140) too many prices in pricelist report
    * Fixed a Bug that showes to many prices on printed Partner Pricelists.
  * [#1153](https://github.com/metasfresh/metasfresh/issues/1153) Pricing wrong w/ more than 1 Packing Instruction
    * Fixed a bug that did not wlloe to define and use prices for product prices withe more than one packing instruction.
  * [#1160](https://github.com/metasfresh/metasfresh/issues/1160) Material receipt label is printed for each TU on an LU
    * Bug Fix for the automatic Label Printing in Material Receipt Process. Now only the defined amount of copies are printed.
  * [#1162](https://github.com/metasfresh/metasfresh/issues/1162) Split from non-aggregate HUs can lead to wrong TU quantities
    * Bug Fix for the Split action in Handling Unit Editor.
  * [#1171](https://github.com/metasfresh/metasfresh/issues/1171) Inactive BPartner is not shown in open items report
    * Fix for the Open Items report. Now also showing Open Items for decativated Business Partners.
  * [#1172](https://github.com/metasfresh/metasfresh/issues/1172) Show only those weighing machines which are available for HU's warehouse
    * Filtering the shown weighing devices to thiose that are valid for the given Warehouse in HU Storage.

* metasfresh-webui-api
  * [#179](https://github.com/metasfresh/metasfresh-webui-api/issues/179) Cleanup metasfresh-webui repository
    * Housekeeping task to cleanup the metasfresh-webui repository, getting rid of discontinued stuff.
  * [#238](https://github.com/metasfresh/metasfresh-webui/issues/238) Attributes propagated on everything in TU
    * Fixes a Bug that allowed to propoagate Attribute Values on a whole Handling Unit just through moving a low level HU into the Handling Unit.

* metasfresh-webui-frontend
  * [#524](https://github.com/metasfresh/metasfresh-webui-frontend/issues/524) Location Editor cannot read property bug
    * Fixing a Bug that broke the functionality of the Location Editor.

# metasfresh 5.0 (2017-10)

## Features
* metasfresh-backend
  * [#987](https://github.com/metasfresh/metasfresh/issues/987) Create a vertical solution for organisations
    * Adding customizations for associations/ organisations as a vertical solution based on metasfresh.
  * [#1000](https://github.com/metasfresh/metasfresh/issues/1000) Support long address in letter window
    * Now long addresses are supported in documents for a proper display in a letter window.
  * [#1035](https://github.com/metasfresh/metasfresh/issues/1035) DLM - restrict number of mass-archived records
    * Performance and Database autovacuum improvement. Segmenting the mass archiving to allow better database maintenance.
  * [#1046](https://github.com/metasfresh/metasfresh/issues/1046) Automatic Naming of Pricelist Version Name
    * Introducing the automatic naming of pricelist Version, adding the needed Information into the Version identifier.
  * [#1070](https://github.com/metasfresh/metasfresh/issues/1070) Price not transferred to flatrate term
    * Enhancing the processing of flatrate Terms after recording in orderline. Now also transferring the price into the flatrate term data after order completion.
  * [#1071](https://github.com/metasfresh/metasfresh/issues/1071) Empties document Jasper takes very long to generate
    * Improving the performance of empties document generation.
  * [#1075](https://github.com/metasfresh/metasfresh/issues/1075) Create Window for Material Tracking in WebUI
    * New Window "Material Tracking" in WebUI, allowing the creation and maintenance of material Tracking datasets in preparation for usage in procurement, receipt and manufacuring. Material Tracking is important for the retraceability of products in metasfresh.
  * [#1079](https://github.com/metasfresh/metasfresh/issues/1079) Refine the Material Receipt Candidates Grid View
    * Adding detailes Layout to material Receipts Candidates Grid view to allow the receipt user to have a better overview.
  * [#1080](https://github.com/metasfresh/metasfresh/issues/1080) Virtual Column for qtyenteredTU from Purchase Orderline in Receipt Candidate
    * Introduced a virtual column qtyEnteredTU in Material Receipt candidate, to be able to compare ordered TU qty with the already received TU Quantity.
  * [#1081](https://github.com/metasfresh/metasfresh/issues/1081) Allow the generic configuration of C_Printing_Queue_Recipient_IDs for system users
    * New Printing Client Functionality to allow the generic configuration of Printing Queue recepients for system users.
  * [#1090](https://github.com/metasfresh/metasfresh/issues/1090) Introduce C_BPartner_QuickInput table/window to capture new BPartners
    * New Table created for Business Partner creation on the fly during Order editing.
  * [#1105](https://github.com/metasfresh/metasfresh/issues/1105) Translate Action in Material Receipt Schedule for de_DE
    * Translating some of the Quickactions in Material Receipt Candidate window.
  * [#1107](https://github.com/metasfresh/metasfresh/issues/1107) Implement interactive mode for RolloutMigrate
    * Adding a interactive mode for sql_remote.
  * [#1113](https://github.com/metasfresh/metasfresh/issues/1113) BPartner quick input modal overlay Layout for WebUI
    * Created a new Layout based on C_BPartner_QuickInput table and open it in Sales Order editing of Order Partner as "new Partner"  action.
  * [#1118](https://github.com/metasfresh/metasfresh/issues/1118) Change migration scripts folder from TEMP to METASFRESH_HOME/migration_scripts/
    * Customizing and migration enhancement. Now the automatically generated migration scripts for application dictionary changes are saved in dedicated migration-scripts filder instead of TEMP.
  * [#1126](https://github.com/metasfresh/metasfresh/issues/1126) Possibility for easiest regression Test with old and new Pricing Hierarchy
    * Testing SQL to check if the migration of old Pricing Hierarchy to new one was sucessful.
  * [#1130](https://github.com/metasfresh/metasfresh/issues/1130) LU Transform "own Palette" Packing material
    * New functionality to set a "own palette" flag in Handling Unit Editor of Material Receipt, to allow the usage of own Packing Material (here only palettes) that are then not added to Material Receipt Lines from the vendor.
  * [#1132](https://github.com/metasfresh/metasfresh/issues/1132) Close/ Open Action for Material Receipt Candidate Lines
    * Adding the Open/ Close processes to quickaction drop-down in Material Receipt candidates Window allowing the user to mark rows as "processed" or reopen processed rows.
  * [#1133](https://github.com/metasfresh/metasfresh/issues/1133) Reorder the columns in Grid View for Material Receipt Window
    * Reordering columns in Material Receipt Grid View in WebUI.
  * [#1135](https://github.com/metasfresh/metasfresh/issues/1135) Translation de_DE for Process Empties receive
    * Adding a new Translation for "Empties receive" action in Material Receipt Candidates Window in WebUI.


* metasfresh-webui-api
  * [#181](https://github.com/metasfresh/metasfresh-webui/issues/181) Transforming HU in Handling Unit Editor
    * New Functionality in Handling Unit Management. Possibility to apply different actions on Handling Units to transform the Packing, Quantities and Hierarchy easily.
  * [#199](https://github.com/metasfresh/metasfresh-webui/issues/199) KPI master data shall provide to frontend a recommended refresh interval
    * New automatic refresh functionality for Dashboard KPI. The KPI now automatically gets the fresh data automatically and updates the KPI with changed data.
  * [#206](https://github.com/metasfresh/metasfresh-webui/issues/206) CU Handling Unit creation without multiline
    * Now the multiline functionality for creating CU without packing material (TU, LU) is allowed also for only 1 selected line.
  * [#207](https://github.com/metasfresh/metasfresh-webui/issues/207) Prohibit Material Receipt w/ selection of multi BP
    * Disallowing the Material Receipt workflow when lines with different vendors are selected. This was a confusing experience for the user, so we decided to switch off this functioanlity.
  * [#208](https://github.com/metasfresh/metasfresh-webui/issues/208) Receive CU w/ possible quantity adjustment
    * Adjustments to the action "Receive CU", now allowing the change of the initial quantity to be received.
  * [#209](https://github.com/metasfresh/metasfresh-webui/issues/209) HU Automatic Label Printing when received
    * New Functionality that automatically prints the Material Receipt Label for the LU as soon as the HU is switched from planning status to active. This allows a more efficient workflow for the user and avoids the printing of labels before being operative (active).
  * [#210](https://github.com/metasfresh/metasfresh-webui/issues/210) Print Material Receipt Document via Material Receipt Candidates Window
    * Added an action that provides the possibility to print the material Receipt Document for all Handling Units of a given Material Receipt candidate Line.
  * [#223](https://github.com/metasfresh/metasfresh-webui/issues/223) Attributes shall be shown on CU level too
    * Possibility to now edit Attributes also on CU Level.
  * [#228](https://github.com/metasfresh/metasfresh-webui/issues/228) Remaining TU Qty in Quickaction and HU Config
    * When using transform actions in Handling Unit editor, now setting the quantity of the source HU automatically in the Parameter window as initial, but overwritable quantity.
  * [#234](https://github.com/metasfresh/metasfresh-webui/issues/234) HU Config in handling Unit Editor
    * Providing an action to transform Handling Units into other Handling Unit combinations in Handling Unit Editor.
  * [#236](https://github.com/metasfresh/metasfresh-webui/issues/236) Remaining TU Qty in Receive HUs window
    * Automatically calculating the remaining TU Quantity to receive in Material Receipt Canddate Window.

* metasfresh-webui-frontend
  * [#126](https://github.com/metasfresh/metasfresh-webui-frontend/issues/126) Add new Business Partner functionality in search Field
    * New Feature that allows to create a new customer Business Partner on the fly when editing a sales Order. This new functionality automatically is suggested to the user when the businesspartner search does not find a result.
  * [#446](https://github.com/metasfresh/metasfresh-webui-frontend/issues/446) Error indicator for fields
    * Introducing new Error indicators for fields, allowing to provide detailed information to the user in case of error situations for a field. The available information is shown with a red color on the field and available when hovering then field with the mouse.
  * [#447](https://github.com/metasfresh/metasfresh-webui-frontend/issues/447) Not saved indicator for Grid view lines
    * Introducting a "not saved indicator" for grid view lines, now giving the user the transparency to recognize why a line cannot be saved.
  * [#448](https://github.com/metasfresh/metasfresh-webui-frontend/issues/448) Query on activate document included tab
    * New functionality to reduce the traffic and ressource load whan opening a window with included subtabs. This new feature allows to flag subtabs as high volume or frequent change and then reloads the data only when the user selects that subtab.
  * [#452](https://github.com/metasfresh/metasfresh-webui-frontend/issues/452) Saving Indicator Bar in modal window
    * Adding the global save indicator bar also to modal overlays.
  * [#482](https://github.com/metasfresh/metasfresh-webui-frontend/issues/482) Quick actions not queried in HU editor for included rows
    * Added a missing functionality, so that now quick actions can be used also for newly added rows in Handling Unit Editor.
  * [#488](https://github.com/metasfresh/metasfresh-webui-frontend/issues/488) Restrict the minimum size of action menu
    * Layout change to prohibit the action menu getting to narrow, disallowing the user to read the actions.
  * [#490](https://github.com/metasfresh/metasfresh-webui-frontend/issues/490) Filter drop-down list too narrow
    * Layout change to prohibit the filter drop-down list getting to narrow, disallowing the user to read the filter criteria.
  * [#510](https://github.com/metasfresh/metasfresh-webui-frontend/issues/510) Improved Not Saved Indicator design
    * Nice improvement for the design of the "not saved" indicator. It is now a thin red line instead of the "progress and save" indicator.
  * [#1073](https://github.com/metasfresh/metasfresh/issues/1073) Material Receipt Candidates order by Purchase Order ID desc
    * New Order by criteria for the Grid view in the Material Receipt Candidates Window.

## Fixes
* metasfresh-backend
  * [#936](https://github.com/metasfresh/metasfresh/issues/936) Logfile on application-server gets flooded
    * Fixes an issue that leads to high volume logging on metasfresh application server.
  * [#1039](https://github.com/metasfresh/metasfresh/issues/1039) Make C_OrderLine.M_Product_ID mandatory
    * Minor Fix making the Orderline ID mandatory.
  * [#1056](https://github.com/metasfresh/metasfresh/issues/1056) Purchase Order from Sales Order process, wrong InvoiceBPartner
    * Fixes a Bug that did not select the correct Invoice Business Partrner vendor from the Partner Releationship having the delivery vendor Partner different than the Invoice Business Partner vendor.
  * [#1059](https://github.com/metasfresh/metasfresh/issues/1059) ShipmentScheduleBL.updateSchedules fails after C_Order was voided
    * Minor fix in the ShipmentScheduler update that failed for a cornercase when the sales Order was voided.
  * [#1068](https://github.com/metasfresh/metasfresh/issues/1068) Settings on Swing Client are saved but window does not close
    * Minor fix in Swing Client Settings window. Changes to the settings were save but it was not possible to close the window via done after any change.
  * [#1076](https://github.com/metasfresh/metasfresh/issues/1076) NoDataFoundHandlers can cause StackOverflowError
    * Fix for a Bug cause through new Data Lifecycle Management Feature.
  * [#1088](https://github.com/metasfresh/metasfresh/issues/1088) pricing problem wrt proccurement candidates
    * Fix a minor Bug that was introduced with the new pricing changes.
  * [#1094](https://github.com/metasfresh/metasfresh/issues/1094) Drop deprecated and confusing I_AD_User get/setFirstName methods
    * Dropping lagacy getter/ setter for FirstName LastName of User data.
  * [#1097](https://github.com/metasfresh/metasfresh/issues/1097) field too small in jasper document for invoice
    * Enhancing a field size in JasperReports Invoice Document.
  * [#1099](https://github.com/metasfresh/metasfresh/issues/1099) Fix Materialentnahme movement creation
    * Includes a fix for the Material Movement creation for used products in Swing Handling Unit editor.
  * [#1103](https://github.com/metasfresh/metasfresh/issues/1103) TU Ordered Qty in Material Receipt Schedule shows movedQty
    * Fix in the virtual column Ordered Quantitity TU that showed the moved Quantity instead.
  * [#1106](https://github.com/metasfresh/metasfresh/issues/1106) inactive org still selectable on login
    * Fixes the login procedure, now disallowing the loging for inactive Organisations.
  * [#1110](https://github.com/metasfresh/metasfresh/issues/1110) webui HU Editor: conversion error when selecting SubProducer
    * Fixing an error that prohibited the editing of Subproducers in the Material Receipt Handling Unit Editor.
  * [#1121](https://github.com/metasfresh/metasfresh/issues/1121) TU receipt label is just a white sheet of paper
    * Fixes an error in the printing process of Material Receipts and Labels via the standalone printing client and WebUI Interface.

* metasfresh-webui-api
  * [#159](https://github.com/metasfresh/metasfresh-webui/issues/159) Error opening the "Report & Process" window
    * Fixes a Bug that prevented the preview of reports via Chrome new Tab.
  * [#187](https://github.com/metasfresh/metasfresh-webui/issues/187) Documents shall automatically have a default value for standard fields
    * Enhancement to automaticall have default values for document standard fields.
  * [#188](https://github.com/metasfresh/metasfresh-webui/issues/188) Field's mandatory flag is not considered
    * Fixes cases in WebUI that shall trigger a mandatory behavior for input fields.
  * [#213](https://github.com/metasfresh/metasfresh-webui/issues/213) Use document's BPartner language when printing
    * Fixes the output of Documents. Now also in WebUI the documents are created in the Business Partner Language.
  * [#222](https://github.com/metasfresh/metasfresh-webui/issues/222) Carrot Paloxe Error in Material Receipt
    * Fixing an error that appeared when receiving HU which were not LU Level.
  * [#225](https://github.com/metasfresh/metasfresh-webui/issues/225) Receipt Candidates - Foto process is not attaching the picture
    * Fixes the save process when taking a photo via webcam in material Receipt Candidates. The Photo is automatically uploaded and saved as attachment to the candidate record.
  * [#237](https://github.com/metasfresh/metasfresh-webui/issues/237) Transform CU on existing TU not working
    * Fixes an error when trying to transform a CU Handling Unit to an already existing TU.

* metasfresh-webui-frontend
  * [#214](https://github.com/metasfresh/metasfresh-webui-frontend/issues/214) Global shortcuts are not working when focused in inputs
    * Fixing some of the global shortcuts when the focus is on an input field.
  * [#465](https://github.com/metasfresh/metasfresh-webui-frontend/issues/465) DateTime widget not respected in included tab
    * Fix that now also uses the correct widget for DateTime fields.
  * [#473](https://github.com/metasfresh/metasfresh-webui-frontend/issues/473) Sidelist broken
    * Fixing a bug that broke the sidelist.
  * [#485](https://github.com/metasfresh/metasfresh-webui-frontend/issues/485) Subtab 100% height broken again
    * Fixing the Layout of included subtabs when subtab lines are able to fit completely on one screen.
  * [#487](https://github.com/metasfresh/metasfresh-webui-frontend/issues/487) Expand batch entry when completed docuement
    * Fixed an error that appeared when the user tried to use the batch entry mode expansion with a completed document.
  * [#489](https://github.com/metasfresh/metasfresh-webui-frontend/issues/489) Grid view not refreshed on websocket event
    * Fix for websocket eventy that triggers the refresh of the Grid View after external data changes.

# metasfresh 4.58.57 (2017-09)

## Features
* metasfresh-backend
  * [#850](https://github.com/metasfresh/metasfresh/issues/850) Add Migration Script to rename Attribute Set Instance Field
    * Global renaming of Label "Attribute Set Instance" to "Attribute".
  * [#968](https://github.com/metasfresh/metasfresh/issues/968) Include webui in the normal rollout process
    * Optimizing the Continuous Integration workflow to allow the build of WebUI in default Rollout Process.
  * [#1028](https://github.com/metasfresh/metasfresh/issues/1028) extract distributable stuff into dedicated repo
    * Create a dedicated repository and moved distributably stuff there for betterseperation of core and customized implementations.
  * [#1040](https://github.com/metasfresh/metasfresh/issues/1040) Have new request type opportunity
    * Included the new Request Type "Opportunity". First step preparing data structure for our new Opportunity Dashboard in WebUI.
  * [#1049](https://github.com/metasfresh/metasfresh/issues/1049) inDispute Fields and Quality% missing in main Invoice Candidate Window
    * Adjustments in Invoice Candidates Window of WebUI. Included Fields with infomration about the Dispute Status and Quality Inspection information of Material Receipt.

* metasfresh-webui-api
  * [#171](https://github.com/metasfresh/metasfresh-webui/issues/171) No packing item selectable for M_HU_PI_Item_Product
    * Now allowing the recording/ editing of Packing Items in CU:TU Configuration of Product.
  * [#182](https://github.com/metasfresh/metasfresh-webui/issues/182) Material Receipt w/ multiple lines and solitary CU Buckets
    * Implementation of multi line receiving in Material Receipt and Handling Unit Editor.
  * [#183](https://github.com/metasfresh/metasfresh-webui/issues/183) Implement userSession endpoint which also provides the timeZone upcoming
    * When parsing JSON Dates without time, always ignoring the sent timezone.
  * [#184](https://github.com/metasfresh/metasfresh-webui/issues/184) Implement KPI service
    * First prototype Implementation for new metasfresh WebUI Dashboard with usage of D3JS Charts.
  * [#191](https://github.com/metasfresh/metasfresh-webui/issues/191) "Not saved yet" info in REST-API
    * Now providing the information up to Frontend that if data has been saved yet in database. This implementation allows to give the user more feedback about editing errors or missing mandatory data.
  * [#200](https://github.com/metasfresh/metasfresh-webui/issues/200) Generic "add new" search field functionality
    * Implementation of a generic functionality to add new data when not found during autocomplete search workflow. This new functionality will be used in search widget and allows to record data on the fly that belongs to the search field column and ID.

* metasfresh-webui-frontend
  * [#377](https://github.com/metasfresh/metasfresh-webui-frontend/issues/377) grid view: when initially clicking on first row, the second one is first selected
    * Changed the focus behavior in Grid View rows. The cursor "jump" is now eliminated. The user can use the keyboard arrow down to now firstly focus and further navigate trhough the grid.
  * [#392](https://github.com/metasfresh/metasfresh-webui-frontend/issues/392) Filters are not respecting mandatory property
    * Adjustment on filter datils for webUI. Now respecting and showing if parameter/ filter fields are mandatory to be filled.
  * [#416](https://github.com/metasfresh/metasfresh-webui-frontend/issues/416) moving scrollbar on arrow key in dropdown
    * Large dropdown lists now scroll down together with keyboard arrow down navigation.
  * [#428](https://github.com/metasfresh/metasfresh-webui-frontend/issues/428) When calling a process from HU editor open the process parameters on top of the HU editor modal
    * Now allowing modal over modal process windows, to allow the usage of actions also in modal overlays.
  * [#435](https://github.com/metasfresh/metasfresh-webui-frontend/issues/435) filter in Material Receipt Candidates does not work
    * Fixing a minor issue that occured when creating and using a filter criteria that does not have any variable parameters.
  * [#458](https://github.com/metasfresh/metasfresh-webui-frontend/issues/458) HU Editor Attribute editing not possible
    * Fixing a Bug that occured when trying to edit attributes in HU Editor for a selected HU Level.
  * [#1004](https://github.com/metasfresh/metasfresh/issues/1004) Order by C_Order_ID desc in Sales Order Window
    * New Order by criteria in Order Window, so that newest Orders always occur at Tio initially.
  * [#1007](https://github.com/metasfresh/metasfresh/issues/1007) Window for PMM_PurchaseCandidate in WebUI
    * New Window in WebUI for Procurement candidates.
  * [#1032](https://github.com/metasfresh/metasfresh/issues/1032) Material Receipt Candidates Grid View finetuning
    * Adjustments to the Material Receipt Candidates fintuning. Rearranged and reduced the columns shown, so allow a better recognition of important data for the Material Receipt end user.

## Fixes
* metasfresh-backend
  * [#1036](https://github.com/metasfresh/metasfresh/issues/1036) Harmonize BL for ModelCacheService.IsExpired
    * Fixing a Bug in the ModelCacheService that considered records to be expired under certain conditions although they weren't.

* metasfresh-webui-api
  * [#140](https://github.com/metasfresh/metasfresh-webui/issues/140) Failed retrieving included documents when one of them is no longer in repository
    * Fixed a Bug that occured in one time situation and restricted the retrieving of included documents.
  * [#160](https://github.com/metasfresh/metasfresh-webui/issues/160) Don't load documents when dealing with attachments API
    * Fix Material Receipt in WebUI to avoid interfering attachments api that cause error in minor cases when receiving HU.
  * [#176](https://github.com/metasfresh/metasfresh-webui/issues/176) Attributes editor problems
    * Fixes an issue that only showed 3 Attribute lines when opening the Attribute Editor.
  * [#177](https://github.com/metasfresh/metasfresh-webui/issues/177) Date range parameters are not consistent with the ones I introduce
    * Harmonized the date ranges selected in WebUI Frontend with the Parameter Date Ranges used for filtering of data in Backend.
  * [#194](https://github.com/metasfresh/metasfresh-webui/issues/194) Quality discount not considered when receipving HUs
    * Now the Quality discount is considered in Material Receipt WebUI.

* metasfresh-webui-frontend
  * [#404](https://github.com/metasfresh/metasfresh-webui-frontend/issues/404) Wrong viewId used when running "Create material receipt" using keyboard shotcuts
    * Fixes an issue that connected the wrong viewID in "created material receipt" workflow using keyboard navigation and selection.


# metasfresh 4.57.56 (2017-08)

## Features
* metasfresh
  * [#739](https://github.com/metasfresh/metasfresh/issues/739) remove X_BPartner_Stats_MV
    * Removing the legacy DB Table with Business Partner statistics, because of big performance penalty. Will be replaces later via modern data storage and KPI in webUI.
  * [#920](https://github.com/metasfresh/metasfresh/issues/920) Show date promised on order confirmation
    * Now displaying the date promised on order confirmation document.
  * [#927](https://github.com/metasfresh/metasfresh/issues/927) Use partner specific product number and name in documents
    * Extending the Jasperreports documents for order confirmation, inouts and invoices. Now displaying further customer specific product numbers and names.
  * [#928](https://github.com/metasfresh/metasfresh/issues/928) have a way to control which contact is used on addresses in order
    * Enhanced functionality for the selection and usage of contact information on order confirmations. Now its possible to do detailed presettings of Business Partner contacts to be used in Sales and purchase workflows.
  * [#941](https://github.com/metasfresh/metasfresh/issues/941) Make TableSequenceChecker more robust with corner cases
    * Enhancing the Table Sequence Checker to allow more robustness. Issues was recognized in corner cases of Data Life-cycle Management archiving process of legacy data.
  * [#942](https://github.com/metasfresh/metasfresh/issues/942) Improve Transparency & Usability of Pricing definitions
    * Huge Improvement of Transparency & Usability of Pricing definitions. The Pricing Data Structure has grown during the last decade to allow very detailed price definitions bases on countries, currencies, products, packages, attributes and more. This lead into a data structure that is tough to understand and maintain for new users. This implementation improves the price hierarchy to allow much easier maintenance and better transparency.
  * [#954](https://github.com/metasfresh/metasfresh/issues/954) Address Layout Dunning Document
    * Changed the Address Layout on Dunning Document to fit better in standardized letter envelope windows.
  * [#956](https://github.com/metasfresh/metasfresh/issues/956) Adjust Price list reports to new data structure
    * Adjustments to existing Price list reports dues to refactoring of new pricing hierarchy and functionality.
  * [#957](https://github.com/metasfresh/metasfresh/issues/957) Empties Returns for Vendors and Customers in Material Receipt Window
    * Implementation of empties return and receive for Business Partners. The new functionality can be used in Material Receipt candidates window and automatically creates Shipment/ Receive documents for empties with predefined settings.
  * [#969](https://github.com/metasfresh/metasfresh/issues/969) mass migration for 2014, 2015 and further
    * Process to allow to archive during operational time for large chunks of data. This is a spacial migration process to prepare environments for the usage of metasfresh Data Life-cycle Management.
  * [#975](https://github.com/metasfresh/metasfresh/issues/975) Set DLM_Level via properties/preferences UI
    * Allows the user to set if his client shall work with archived data or only show operational data (highly improved performance).
  * [#993](https://github.com/metasfresh/metasfresh/issues/993) New ProductPrice Window for Price Maintenance
    * A new Windows called Product Price which allows the easy filtering and maintenance of all product prices. The user filters the data via preset Price List version and is able to maintain the data vie Grid view or single view/ advanced edit.
  * [#981](https://github.com/metasfresh/metasfresh/issues/981) Introduce AD_PInstance(AD_Pinstance_ID, ColumnName) unique index
    * Minor improvement to raise the reading performance of Process Instances.
  * [#983](https://github.com/metasfresh/metasfresh/issues/983) Upgrade guava version from 18 to 21
    * Upgrading guava (google core libraries) from version 18 to 21.
  * [#986](https://github.com/metasfresh/metasfresh/issues/986) Handle the case that PO can't load a record
    * Allows now fallback scenarios (for example retry) for the Persistance Object to retry in case of thrown exceptions during record loading.
  * [#1018](https://github.com/metasfresh/metasfresh/issues/1018) support description fields in shipment
    * Add the fields description bottom and description to metasfresh client in Shipment Window and displays the field content also on Shipment Jasperreports.

* webUI
  * [#146](https://github.com/metasfresh/metasfresh-webui/issues/146) Receipt schedules: show empties receive/return actions only when only one row is selected
    * Possible actions are now only shown when at least 1 Grid View row is selected. if none are selected then the actions menu is shown, but actions are not able to be started.
  * [#147](https://github.com/metasfresh/metasfresh-webui/issues/147) HU editor: hide filters because they are not supported atm
    * Currently hiding the filter selection in Handling Unit editor until the implementation of filtering is also done in this modal overlay window.
  * [#138](https://github.com/metasfresh/metasfresh-webui/issues/138) change name of new record button
    * The button for new Record is now variable depending on the settings in ad_menu and ad_menu_trl.
  * [#252](https://github.com/metasfresh/metasfresh-webui-frontend/issues/252) Add keyboard handling in POS   
    * Implemented an improved keyboard navigation in the new metasfresh WebUI. Shortcuts and unified behavior is now provided among different windows.
  * [#215](https://github.com/metasfresh/metasfresh-webui-frontend/issues/215) Shortcut for direct Document Action "complete"
    * Further usability Improvement. Added a new shortcut for document complete action. This action is mostly used among all documents and reduces the amount of user keystrokes or mouse click by 1 per document.
  * [#227](https://github.com/metasfresh/metasfresh-webui-frontend/issues/277) Processed HU in Material Receipt Workflow
    * When creating a Material Receipt in handlign Unit editor, then the processed Handling Units are now read-only and are grayed out, so the user can distinguis very well beween proceed and unprocessed Handling Units.
  * [#282](https://github.com/metasfresh/metasfresh-webui-frontend/issues/282) Implement attachments list in Actions menu
    * The action menu now shows another section called "attachments" where all files are listet that are attached to the currently selected record (e.g. product record, document). Photos made per Webcam and uploaded are also automatically shown as Photo attachment.
  * [#323](https://github.com/metasfresh/metasfresh-webui-frontend/issues/323) Provide login credentials in request body
    * Created a new API to provide the login credentials in the request body instead of parameters.
  * [#996](https://github.com/metasfresh/metasfresh/issues/996) Add Warehouse and processed Filter to Material Receipt Candidates Window
    * The Window Material Receipt candidates has now 2 further filter selections (Warehouse, processed). This allows the user to search and filter the needed Data much faster.
  * [#265](https://github.com/metasfresh/metasfresh-webui-frontend/issues/265) Create Jenkinsfile for metasfresh-webui-frontend
    * Including the automatic build of the metasfresh WebUI into the Jenkins Build Infrastructure.
  * [#345](https://github.com/metasfresh/metasfresh-webui-frontend/issues/345) Grid view layout: honor supportNewRecord and newRecordCaption
    * Implementation that brings New Record information up to the frontend and allowss the frontend now to react in a more flexible way.
  * [#162](https://github.com/metasfresh/metasfresh-webui/issues/162) Possibility to choose used filter criteria for webUI
    * Reducing the amount of predefined filter selections per window to saved filter sets created by special user.
  * [#1014](https://github.com/metasfresh/metasfresh/issues/1014) Window Layout Purchase Order: Warehouse
    * This is an Feature List Item that is part of an Feature List. Notice the connector between the three graphics to show that they are related.

## Fixes

* metasfresh
  * [#161](https://github.com/metasfresh/metasfresh-webui/issues/161) Button Action in Subtab for Price List Version creation
    * Enabled the functionality in WebUI to generate new Product prices via the Pricelist Version record and configured calculation Schema with source Price List.
  * [#912](https://github.com/metasfresh/metasfresh/issues/912) New role added .. login not possible after that
    * Fixed a minor Bug that restricted the login after creating a new Role.
  * [#998](https://github.com/metasfresh/metasfresh/issues/998) ClassNotFoundException: de.metas.dlm.swingui.model.interceptor.Main
    * Bugfix for ClassNotFound Exception in Data Life-cycle Management Interceptor.
  * [#1010](https://github.com/metasfresh/metasfresh/issues/1010) M_ProductPrice with Season fix price=Y should not be modified when copied
    * Fix that now prohibits the modification of Product Prices which are flagged as SeasonFixPrice during copy.

* webUI
  * [#124](https://github.com/metasfresh/metasfresh-webui/issues/124) Default/ Standard Filter not correct in WebUI
    * Fix to show the right default Filters in WebUI as defined in Search Columns in Swing Client for a given window.
  * [#135](https://github.com/metasfresh/metasfresh-webui/issues/135) process parameter defaults are not set
    * Fix that ensures the proper setting of report Parameters in WebUI to Jasperreports to allow creation of reports.
  * [#137](https://github.com/metasfresh/metasfresh-webui/issues/137) Make sure ProcessInstance is not override by concurrent REST api call
    * Fixing timing conditions that lead to overriding ProcessInstance through concurrent REST API call.
  * [#141](https://github.com/metasfresh/metasfresh-webui/issues/141) edit address not working anymore
    * Fix to allow the usage of buttons in the advanced edit overlays of WebUI (for example Button for location editor or Attributes Editor)
  * [#145](https://github.com/metasfresh/metasfresh-webui/issues/145) HU editor - Create material receipt not enabled when the whole palet is selected
    * Fix that enables the QuickAction in Handling Unit Editor of Material Receipt when selecting an HU with LU Level (e.g. Pallet)
  * [#150](https://github.com/metasfresh/metasfresh-webui/issues/150) Material Receipt Candidates not updated after receive HU
    * Fixed a Bug that occured when doing mass enqueing of invoice candidate lines of different business partner.
  * [#155](https://github.com/metasfresh/metasfresh-webui/issues/155) Error in invoice candidate enqueuing
    * Fixed a Bug that occured when doing mass enqueing of invoice candidate lines of different business partners.
  * [#157](https://github.com/metasfresh/metasfresh-webui/issues/157) Receive HU opens with 10 LUs
    * Bugfix for Material Recipts via Handling Unit Editor. Always opened with wrong amount of Top Level Handling Units (LU).
  * [#164](https://github.com/metasfresh/metasfresh-webui/issues/164) Create migration script for missing Menu
    * Recreated the missing migration for the newly built WebUI menu with flatter and more comprehensible Hierarchy and Structure.
  * [#168](https://github.com/metasfresh/metasfresh-webui/issues/168) internal: Don't create layout elements if there are no fields inside
    * Fixed a Bug that occured first time in General Ledger window in WebUI, caused through layout elements without included fields.
  * [#170](https://github.com/metasfresh/metasfresh-webui/issues/170) date attributes in hu modal window
    * Bugfix to allow the setting and editing of attributes in date format.
  * [#171](https://github.com/metasfresh/metasfresh-webui/issues/171) No packing item selectable for M_HU_PI_Item_Product
    * Fix to allow the user to select the Packing Item field in WebUI.
  * [#172](https://github.com/metasfresh/metasfresh-webui/issues/172) Entries skipped at the begining of pages
    * Fixed a User Interface bug that caused ugly jumps of the Grid View/ Table View when turning pages.
  * [#263](https://github.com/metasfresh/metasfresh-webui-frontend/issues/263) Grid view attributes were queried when there are no rows
    * Fix in Handling Unit Editor that was trying to read data for an already reversed/ vanished Handling unit.
  * [#294](https://github.com/metasfresh/metasfresh-webui-frontend/issues/294) Leave Location editor with no entry
    * Bugfix. The user is now allowed to leave the location editor in Business Partner Location without changing any data.
  * [#311](https://github.com/metasfresh/metasfresh-webui-frontend/issues/311) Fix the scrollbars when having an overlay grid view
    * Bugfix. The user is now allowed to leave the location editor in Business Partner Location without changing any data.
  * [#313](https://github.com/metasfresh/metasfresh-webui-frontend/issues/313) Scrollbar missing on LU/ TU Level in HU Editor
    * Rearrangement of the Handling Unit Editor layout to not overload the window with too many scrollbars when not really needed.
  * [#314](https://github.com/metasfresh/metasfresh-webui-frontend/issues/314) Grid view filtering: don't send valueTo if it's not a range parameter
    * Avoid the sending of the valueTo as longs it's not a range parameter.
  * [#315](https://github.com/metasfresh/metasfresh-webui-frontend/issues/315) Quick action button layout is broken on smaller resolution
    * Fixed the responsive layout of the Quick Input Button behavior on smaller screen resolutions.
  * [#317](https://github.com/metasfresh/metasfresh-webui-frontend/issues/317) Quick actions are not refreshed when opening the modal HU editor
    * Fix that now refreshes the list of available quick actions when opening the modal Handling Unit Editor overlay.
  * [#322](https://github.com/metasfresh/metasfresh-webui-frontend/issues/322) Quick input's mandatory=false not respected
    * Now evaluating the mandatory false parameter in Quick Batch entry functionality.
  * [#330](https://github.com/metasfresh/metasfresh-webui-frontend/issues/330) HUEditor displays HUs which are destroyed
    * The Handling Unit is now not showing Handling Units anymore which are destroyed (e.g. after reversing the creation of an already active Handling Unit).
  * [#331](https://github.com/metasfresh/metasfresh-webui-frontend/issues/331) Debug/fix: if a PATCH operation fails some wrong calls are performed
    * Bugfix for Patch Operation that lead into wrong calls to REST API.
  * [#333](https://github.com/metasfresh/metasfresh-webui-frontend/issues/333) The whole process parameters content vanished
    * Process Panel fix in Handling Unit Editor that caused the initialization of the whole panel and left it empty.
  * [#353](https://github.com/metasfresh/metasfresh-webui-frontend/issues/353) Wrong sitemap breadcrumb
    * Fix for a minor Issue that showed the wrong breadcrumb path when opening the sitemap.
  * [#354](https://github.com/metasfresh/metasfresh-webui-frontend/issues/354) Filter w/o variable Parameters not working
    * Fixed a Bug that prevented Filter selections without variable Filter criteria included.
  * [#364](https://github.com/metasfresh/metasfresh-webui-frontend/issues/364) Handling Unit Double click Icon changes data underneath overlay
    * Now preventing clicks on modal overlay leading to navigational main window changes underneath.
  * [#259](https://github.com/metasfresh/metasfresh-webui-frontend/issues/259) Grid view selection lost when trying to use the scroll bar
    * Now preventing clicks on modal overlay leading to navigational main window changes underneath.
  * [#352](https://github.com/metasfresh/metasfresh-webui-frontend/issues/352) Lines not "refreshed" after docaction reactivation
    * Bugfix that now refreshes the document lines after reactivation action.
  * [#383](https://github.com/metasfresh/metasfresh-webui-frontend/issues/383) Shortcut for Batch entry space not usable when in input field
    * Fix for keyboard navigation shortcut that now allows the direct jump to Quick Batch entry even when in field focus.
  * [#376](https://github.com/metasfresh/metasfresh-webui-frontend/issues/376) Don't render unknown widget types but log in console
    * Built restriction to not render unnown widget types in metasfresh WebUI.
  * [#350](https://github.com/metasfresh/metasfresh-webui-frontend/issues/350) Strange pulse effect in Subtab Gridview
    * Fix for minor issue in Pulse effect when updating document rows.
  * [#176](https://github.com/metasfresh/metasfresh-webui/issues/176) Attributes editor problems
    * Now the editing of all listed attributes are allowed in Attribute editor when displayed.

# metasfresh 4.56.55 (2017-07)

## Features
* metasfresh
  * #913 include branch name in build version string
    * Added the branch name into the build version string to be able to distinguish between builds & rollouts in development branches.

* webUI
  * #112 On login page, deactivate the fields while logging in
    * Now making the login fields read-only as soon ad the authentication process is triggered.
  * #118 Functionality to easily add files to current record in webUI
    * New Functionality to upload files to a given dataset in the new WebUI. This implementation is also used for the new attachment functionality.
  * #120 Material Receipt WebUI: Attribute Values wrong
    * Instead of short Attribute identifiers now the resolved values are shon in the Attribute Editor.
  * #121 Empties Returns for Vendors and Customers in Material Receipt Window
    * New Functionality in WebUI. Possibility to create empties return/ receive documents quickly from Material Receipts window.
  * #127 Receipt schedules - Receive with configuration improvements
    * Enhanced configuration and saving functionality in material receipt workflow in WebUI.
  * #132 Receiving HUs: already received HUs shall be flagged as processed
    * Now flagging the already processed Handling Units in material Receipts workflow as processed and make visible to the user.
  * #226 Implement document field device support
    * New generic Device functionality to add device buttons to an input field. In the first Implementation used to attach weighing machines to receive the current value for gross weight field. Can be used in Material Receipt window/ Handling Unit editor.
  * #227 Wrong breadcrumb when the view is opened after process execution
    * Adjust for the breadcrumb navigation to show the corresponding path after process execution from window action.
  * #254 Cannot see the HU editor icons
    * Added missing HU editor icons for logistic-, transport- and customer-unit level.
  * #256 Implement document attachments
    * New, fast and easy implematation to upload attachments to an existing record in metasfresh.
  * #257 login page: focus on username
    * When opening the login page to enter metasfresh webUI then initially have the focus on Username field.
  * #275 None of the menus could be opened when in full screen mode
    * Allows to open all top bar menues now, also when quick batch entry mode is activated.
  * #281 Remove margin from wrapper modal to make 0-padding inside
    * Adjusting the look and feel of the modal overlay, now reducing the padding to minimum.
  * #734 Add Translation for en_US in WebUI
    * Translation of metasfresh is now available in en_US.
  * #833 Invoice Process in Invoice Candidates WebUI
    * Add the Invoiceing process to easy create customer and vendor invoices from filtered and selected records in invoice candidates window in webUI.
  * #894 Payment Allocation Window WebUI
    * Include the Payment allocation window in new Web User Interface.
  * #895 Dunning Candidates Window WebUI
    * Include the Dunning Candidates window in new Web User Interface.
  * #947 Window Greeting Add Translation for en_US
    * Minor enhancement, translating the Greeting window for language en_US.
  * #966 Provide WebUI Default Role
    * Add a default role and permission to use the already implemented functionalities for the new Web User Interface.

## Fixes
* metasfresh
  * #797 Zoom does not open new document
    * Fix that allows to open a referenced document record in metasfresh via the reference action and zoom accross.

* webUI
  * #119 Error when Pressing the Attribute Button
    * Fixes an error that occured in sales order advancededit and grid view edit when trying to record product attributes.
  * #116 qty 0 in purchase order
    * Fix for the Quick batch entry bug that leads into wrong quantity 0 in generated order line.
  * #229 Location editor button called "edit attributes"
    * Minor fix renaming the button for Location editing.
  * #261 When the attribute is readonly don't show the Device button(s)
    * Making the new Field device buttons invisible when the corresponding field in read-only.
  * #264 Included tabs layout is broken
    * Fix for the broken layout of included tabs when opened in lower screen resolution.
  * #268 Wrong viewId when starting the process
    * Fix that now provides the correct View-ID as process Parameter.
  * #276 Wrong timing when completing a quick input entry
    * Fix for the Quick Order Batch entry that leads to wrong prices in certain cases.
  * #279 While browsing a document, pressing New does nothing
    * Fixing the new document functionality in action menu while viewing a document in detail view.
  * #295 Attribute Editor too narrow
    * Makes the Attribute Editor now better readable.

# metasfresh 4.55.54 (2017-06)

## Features
* metasfresh
  * #877 Make "Wareneingang POS (Jasper)" report work with M_ReceiptSchedule_ID as parameter
    * Adapt the reports for Material Receipt to work with Receipt Schedule ID as Paramater. This is needed for the new Material Receipt Workflow in WebUI which is now based on generic Material Receipt Schedule Window.
  * #460 Provide aggregate HUs
    * Introduce the Handling Unit compression to only store and process the minimal needed information about Handling Units per step in supply chain. This Implementation is a huge Performance gain in Handling Unit processing.
  * #815 Jasper Footer: Show bank account in one line
    * Adjust the Jasper Reports Footer subdocument. Show all bank information now in same line.
  * #904 New Field "Zulieferant" in R_Request Window
    * Add new Field in Request window to allow the storage of an explicit Vendor Businesspartner.
  * #914 adjust weight in Docs_Purchase_InOut_Customs_Details function
    * Adjust the customs report to fit for swiss requirements in customs reporting. The gross weight is now calculated as Handling Units weight minus weight Logistics Unit Package Item.

* webui
  * #873 Customer & Vendor Subtab in BPartner Window WebUI
    * Add and arrange the customer and vendor subtab in Businesspartner Window in Web User Interface.
  * #196 Grid View 100% height
    * Adjust the Grid view height to expand to screensize.
  * #795 Price Window WebUI Layout
    * Add the Layout for the Price window in WebUI.
  * #896 Dunning Window WebUI
    * Add the Layout for the Dunning Window in WebUI.
  * #194 Open views from process execution result
    * Add a new functionality that allows process results to receive a Window ID and open the corresponding Window after finishing the process execution.


## Fixes
* metasfresh
  * #857 Fix String Attributes Save in POS
    * Fix that now allows the possibility to save String Attribute in POS Windows also without loosing focus for recorded field.
  * #863 No Result Window for Prosesses that don't allow rerun
    * Fix for rerun parameter in Processes. Now possible to switch off the rerun confirmation Window after Process.
  * #879 Fix "ValueType not supported: D" when HU attributes are generated
    * Minor Fix for Value Type of generated HU Attributes.
  * #781 ESR scan processing returns improper bpartner
    * Fix and Enhancement of ESR Scan functionality in Purchase Invoices. Now allowing to select alternative Business Partner for on the Fly Bank Account generation.
  * #783 DocAction on Sales Order not available although permission existing
    * Sysconfig to certrally enable/ disable the Document Action Close.
  * #813 hide packing instruction and qty when null
    * Fix that does not show the Packing Instruction and Packing Qty on documents anymore when null.
  * #903 Jenkins build error with slash in branch name
    * Minor Fix for Jenkins Build.
  * #870 Invoice Candidate price-qty overwrite lost when ReverseCorrect
    * Fix that stores the price & qty override in Invoice Candidates after Reverse-Correct of Invoice.
  * #910 Put explicit delivery date on invoice
    * Add the precise description for delivery date as demanded by german law.

* webui
  * #204 Can not complete Order
    * Minor Fix that now allows the completion of Sales Order in Web User Interface.
  * #886 GrandTotal missing in Purchase Order Grid view
    * Fix that enables the display of Grandtotal Field in Purchase Order Grid View.
  * #179 Fields too short for documentno in Breadcrumbs
    * Fix that extends the number of visible digits (now 9 digits) in Breadcrumb menu for Document or masterdata identifiers.

# metasfresh 4.54.53 (2017-05)

## Features
* metasfresh
  * #858 Adjustments for Shipment Schedule Grid View
    * Minor changes on the Grid View for the Shipment Schedules Window.
  * #868 Weekly Revenue Report
    * Create a weekly Revenue Report in Jasperreports. Similar to the montly report, just comparing different weeks instead months.
  * #827 use the barcode field to select HU using attribute value
    * New feature to be able to scan barcode attrivutes attached to a Handling Unit fir precise identifying.

* webUI
  * #198 Process with parameters cannot be started
    * Fix a Bug in WebUI that did not allow the start of processes with parameters.
  * #205 Batch entry Dropdown for Handling Unit Missing in Workflow
    * Add a Packing Unit dropdown in combined Product Field in Sales Orderline Batchentry.
  * #206 Deleting Batch entry product with "X" only deletes Product not Handling unit
    * Now allowing to delete the whole content of the combined Product-Packing Unit Field.
  * #208 After New autofocus on first record field
    * New UX Feature that automatically sets the focus onto the first recordable Field in Window when "New Record"
  * #213 Do not focus fields "in background" when in Expanded view
    * Adjust the navigation behavior and sequence when using TAB jumping from field to field, now avoids that the focus gets "under" the overlay panel.
  * #218 Reduce Gap Height between Layout Sections
    * Refine UX. Reduced the height between Layout Sections to not have the feeling of having a too big gap between them.
  * #862 Payment Window in WebUI
    * Include the payment Window in WebUI.
  * #873 Customer and Vendor Subtab in BPartner WebUI Window
    * Include the Customer and Vendor Subtab in Business Partner Window.
  * #883 Sales Purchase Order Window Grid View
    * Include the Grid View for the Sales and Purchase Order in WebUI.
  * #878 Purchase Order Window WebUI
    * Include the Purchase Order Window in WebUI.

## Fixes
* metasfresh
  * #782 Focus on the first process parameter
    * Fix to allow the first recordable Field having focus when opening a process paramater window.
  * #864 Adjust C_Country Location Print generation DE
    * Adjust the Location capture Sequence for Germany.

# metasfresh 4.53.52 (2017-04)

## Features
* metasfresh
  * #800 Order by product name and partner name in pmm_PurchaseCandidates
    * Add a new possibility to be able to sort combined search fields by a selected element in the combined Field, e.g. a field combined as Value + Name can now be sorted with Name, and not just Value + Name.
  * #829 receivedVia entry not translated in Baselanguage de_DE
    * Add the Translation for receivedVia Field in current Baselanguage de_DE.
  * #810 Propagate Attribute from Issue to Receive in Production
    * New Functionality to propagate selected Attributes vertically though a manufacturing process, from action issue to action receipt.
  * #835 Switch off Process Confirmation Window
    * Switch off all process confirmation Windows per default. These can be switched on individually per Process where wanted.

* webui
  * #817 Request Window in WebUI
    * Initial setup of Request Window in Web User Interface including default view, advanced edit, grid view and sidelist.
  * #831 Default Document Layout for WebUI
    * Overhaul of the current general Document Layout for WebUI
  * #847 Shipment Schedule Window in WebUI
    * Initial setup of the Shipment Schedule Window in Web User Interface.
  * #853 Shipment Schedule Window Subtabs in WebUI
    * Add the Subtabs definition to Shipment Schedule Window in the new metasfresh Web User Interface, including Sidelist.
  * #855 Shipment Schedule Advanced Edit Mode
    * Setup for the Advanced Edit Mode of Shipment Scheule in WebUI.
  * #108 Create Callout for DocNo in Request
    * Adjustment/ Enhancement of the DocumentNo Generation in non Document datastrucures of WebUI


## Fixes
* metasfresh
  * #785 Make M_InOutLine.IsInvoiceCandidate Iscalculated
    * Adjust the flag isInvoiceCandidate to be calculated for M_InoutLine records.
  * #808 DocActionBL.retrieveString method is broken
    * Fixing the method that retrieves the Document Action Name.
  * #819 fix/refactor CalloutRequest
    * Adopting the Callouts in Request window to also work in Web User Interface.
  * #806 Customs report minor fixes
    * Minor adjustments and fixes in the Customs report.
  * #837 Marginal return accounts doubled
    * Minor Bug Fix in marginal return report that doubled the sums on certain accounts.
  * #844 Gear from Pricing System and PriceList show wrong processes
    * Fixing a Bug that leads into wrong representation of Processes in Gear of Pricing System and Priceliste Window.

* parent
  * #3 Add repo.metasfresh.com also as plugin repo
    * thx to @sramazzina

# metasfresh 4.52.51 (2017-03)

## Features
* metasfresh
  * #774 show address on all docs so it fits the letter window
    * Adjust all Documents so that the address fits into the letter window od envelops C5/ C6 according to ISO 269 und DIN 678.
  * #773 show delivery address on sales order
    * Show the deliverTo location on Sales Order Documents.
  * #507 Copy with Details for PP_Product_BOM
    * Add a new Functionality to allow copy-with-details on Bill of Materials records.
  * #780 Have logo on jasper report that spans from left to right
    * Rearranged the logo placing on Documents to allow the upload and usage of large, page-spanning Logos from left to right.
  * #816 Do not show prices on shipment note
    * Undisplayed the prices on shipment documents.

## Fixes
* metasfresh
  * #615 Purchase Order wrong Price from Contract or Pricesystem for specific Product
    * Addresses the possible case of different procurement products that have different attributes and still both match equally well.
  * #791 Create Nachbelastung from Invoice Cast exception
    * Fixes a Bug that lead into an exception when creating an adjustment charge to an existing invoice.
  * #761 Reactivating an InOut fails sometimes
    * Now the reactivation of InOuts also works with records that were deleted at the time the async-package is processed

# metasfresh 4.51.50 (2017-02)

## Features
* metasfresh
  * #696 add multi line description per order line
    * Possibility to now add multiline descriptions. These can be used to add individual Texts to an Orderline.
  * #755 Automatic upload orders in csv file with COPY into c_olcand
    * Enhancement to allow the Upload of Sales Orders into Order Candidates via COPY.

## Fixes
* metasfresh  
  * #752 request report does not show requests that don't have product or inout
    * Fix to show request lines in report, which don't have a product included nor a reference to an inout line.
  * #759 Destroyed HU causes problem with shipment creation
    * Fix problem when checking for not-yet-delivered M_ShipmentSchedule_QtyPicked records, the system did not check if they reference actually destroyed HUs.
  * #766 fix for "DocumentPA will not be intercepted because final classes are not supported"
    * Fix this error shown on server startup. Making DocumentPA not final anymore.
  * #770 When extending a procurement contract, null becomes 0.00
    * Fix an issue that set the price to 0,00 when extending a procurement contract, although the initial price was null which means "not set".

# metasfresh 4.50.49 (2017-01)

## Features
* metasfresh
  * #615 Purchase Order wrong Price from Contract or Pricesystem for specific Product
    * Working Increment that works for the current requirement at hand.
  * #653 Calculated DailyLotNo in Material Receipt Candidates
    * Add a Daily Lot No. thats calculated as Day from year, from a given Date in Purchase Order, Orderline Attributes.
  * #714 Marginal Return report calculation add additional Costcenter
    * Adjust the marginal return report to show allow more columns with cost center sums on 1 page.
  * #742 R_Request column c_order_id autocomplete too slow
    * Take out the autocomplete of c_order_id to speed up the lookup performance in R_Request.

## Fixes
* metasfresh
  * #757 Automatic contract extension doesn't work anymore
    * Fix the automatic extension of contracts when flatrate term conditions are met.
  * #681 Automatic filling of BPartner and Location only shows value
    * Fix the Search Field reference that showed only the value, instead of Name and value, in case of BPartner and BPartner Location.
  * #718 Wrong location in empties vendor return
    * Close the Gap that allows to record empty returs with BPartner Location that does not belog to the empties BPartner.
  * #744 Report Bestellkontrolle promised Date-Time seems to have am/pm time formatting
    * Adjust the Purchase Order control report to have the correct locale for time formatting.
  * #763 material receipt HU label always shown in preview
    * Migrate the Handling Unit label enabling direct print, without print preview.

* webui
  * #89 Adjust DocAction Names
    * Adjust/ migrate DocAction Names for WebUI.

# metasfresh 4.49.48 (2016-51)

## Features
* metasfresh
  * #489 Implement DLM within single logical tables
    * Data Life-cycle Management Implementation to enable archiving of non-operational data to separate partitions.
  * #682 Translation in window Vendor Returns
    * Add german translation of additional Fields in Window Vendor Returns.

* webui
  * #698 Pipeline - add webui deployment
    * Add a new Pipeline into Continuous Integration/ Deployment for metasfresh WebUI.

## Fixes
* metasfresh
  * #380 duplicate lines in inout
    * Worked over each jasper report in order not to display materdata records that were deactivated.
  * #710 MRP Product Info: Qtyies issued to a production shall be subtracted from onhand qty
    * Fix a Bug that prevented Handling Units Storage to be adjusted when adding raw material to manufacturing order via action issue.
  * #724 Aggregation Shipment Jasper Documents shows reference from other ad_org_id
    * Extend the where clause for matching of PO References in Aggregation inout documents. Additional Aggregation matching criteria now are ad_org_id, c_bpartner_id.
  * #713 Marginal Return Report (short version) doubled sums for accounting group
    * Fix a partially double summed up accounting group in marginal return Report.

# metasfresh 4.48.47 (2016-50)

## Features
* metasfresh
  * #677 make customs report faster
    * Significant improvement of the customs report performance.
  * #541 Remove PiPo from metasfresh removing code and data
    * Remove the legacy code from Pack-In and Pack-out from metasfresh. The underlying concept is flawed and does not scale.

* webui
  * #625 Shipment Schedule Window WebUI
    * Add initial Layout configuration of Shipment Schedule window in metasfresh WebUI.
  * #687 webUI bundle
    * Add different Layout changes in a fair amount of windows for Web User Interface.

## Fixes
* metasfresh
  * #679 Bug in ClientUpdateValidator
    * Fix a Bug in ClientUpdateValidator that avoided starting the client via eclipse for local-build.
  * #721 Wrong error message displayed when user enters wrong password on login
    * Fix for Bug when entering wrong password in Login. Said "locked" but was just wrong credentials/ password.

# metasfresh 4.47.46 (2016-49)

## Features
* metasfresh
  * #639 Marginal Return report calculation does not check ad_org_id
    * Extend the marginal return report with ad_org_id parm to allow to seperate user for other organisations.
  * #585 Adjust the remaining Property names
    * Change properties to metasfresh namespace.
  * #661 Cultivation Planning report adjustments
    * Adjustments made to the cultivation planning report in procurement.
  * #515 Generating C_Flatrate_Term from C_RfQ_Response then don't complete the term
    * Avoid automatic completion of flatrate term contracts when triffered manually from process gear. This allows the user to record further adjustments after creation.

* webui
  * #48 Add initial setup of kibana kpi for new webUI dashboard
    * Setup an initial set of 10 key perfroamnce indicators for the new metasfresh webui.
  * #59 User friendly URL for Print Endpoint
    * Add a user frindly/ comprehensive endpoint for document printing tab in webUI.
  * #45 Dashboard Target area backend support
    * Add support for Target widgets and target widget area in webUI dashboard
  * #567 WebUI - Material Receipt Schedule
    * Initial set of windows, grid views, sidelist and elements and fields for material receipt schedule window.

## Fixes
* metasfresh
  * #658 make Ini more robust: throw ex if file can't be read
    * Fix error with long loading of ini file in Tomcat.
  * #664 R_Request Performance Issue
    * Swap Table direct references against search in all R_Request table/ subtable fields to reduce current performance issues.
  * #674 Filter operator "between" broken
    * Fix the operator "between" which is used in filtering/ search criteria.

* webui
  * #67 Error when introducing parameters to report
    * Fix parameters support for report usage in webui.
  * #70 Add BPLocation Error
    * Fix Errors that prevented the creation of new Business Partner Location lines in webUI.

# metasfresh 4.46.45 (2016-48)

## Features
* webui
  * #425 Kickstart elasticsearch integration
    * Add the first prototype of elasticsearch integration in WebUI environment of metasfresh ERP. Data for elasticsearch index is created via metasfresh async framework.
  * #598 WebUI Dashboard initial Prototype definition
    * Create a prototype dashboard in new metasfresh WebUI. Current prototype uses kibana for KPI and data visualization.

## Fixes
* metasfresh
  * #583 Reports without ad_org_id show wrong results
    * Add support for multi organisation usage of selected 22 reports.
  * #620 Marginal Return Report doubled sums for accounting group
    * Fix the doubled sums in Marginal return report for specific accounting group.    
  * #656 Bug in Import Format - Copy lines process
    * Fix a minor Bug in Import format.
  * #646 Fix support for groovy scripts
    * Fix groovy Script support and extend fieldsize for script recording.

# metasfresh 4.45.44 (2016-47)

This week's RC

## Features
* metasfresh
  * #515 Generating C_Flatrate_Term from C_RfQ_Response then don't complete the term
    * Adjust the completion process of Flatrate terms created manually. Now the flatrate term in not completed and can be manually adjusted by the user without reactivating.
  * #563 Report Statistics qty per Week
    * New sales qty report that shows the sold product quanities per week and in comparison the last 11 weeks.
  * #579 Handling units without washing cycle shall be allowed in washing Manufacturing Order
    * Adjustment of Handling Unit permissions in manufacturing order, initially filtering out HU with washing cycle set.
  * #597 Empties mask and functionality with autom. set the selected bpartner
    * New functionality to add informations about Businsspartner, Location and Purchase Order Reference. This allows the to raise the efficiency when checking and creating purchase invoices via invoice candidates.
  * #576 Report Reclamation result, quality note and minor changes
    * New reqirements implemented in reclamation report.
  * #539 Add missing FK constraints
    * Add further missin Foreign Key constraints surfacing during Data Lifecycle Management implementation.
* webui
  * #567 WebUI - Material Receipt Schedule
    * Add initial Screen Layout for Material receipt schedule in metasfresh WebUI.
  * #497 WebUI - ShipmentSchedule Window
    * Add initial Screen Layout for Shipment Schedule in metasfresh WebUI.

## Fixes
* metasfresh
  * #589 console error when doing bpartner setup
    * Fix a minor bug with jax-rs/ jms timeout in Business Partner setup workflow, which contantly popped up in console.
  * #553 Report Account Info adjustments. Add parms date range.
    * Add the parms date range back into Account Info report in Jasper.
  * #611 IBAN Error for RBS Bank
    * Add support for RBS Bank in metasfresh IBAN check when creating a new Businesspartner Bankaccount.

# metasfresh 4.44.43 (2016-46)

## Features
* metasfresh
  * #553 Report Account Info adjustments. Add parms date range.
    * Enhancing the Filter parms to allow variable daterange for selection.
  * #557 Report Saldenbilanz & Account Info native Excel Export
    * Now Allowing an Excel Export though Report viewer process.
  * #558 Marginal return calculation - Accountings without c_activity_id
    * Marginal Return now considers specific records without activity to be calculated on account specific one.
  * #568 Change on Report "Lieferschein" for one specific Customer
    * Add properties File for Shipment Report.
  * #555 Businesspartner Location isEDI shall not be ticked by default
    * Don't set the Flag isEDI per default when recording new Businesspartner Loactions.
  * #548 keep M_QualityNote and M_AttributeValue in sync
    * New Functionality to sync the M_QualityNote and M_AttributeValue for R_Request complaints usage.
  * #577 Button Request shows too many results
    * Adjust the Filtering of Request Button in main menue and show Role Based counter.
  * #565 Report Revenue per Week and BPartner also show qty
    * Add a new Quantity value in reports Revenue per week and week Businesspartner.
  * #416 Extended async notification features
    * Prepare the notification features for WebUI exposure in metasfresh nextGen.

## Fixes
* metasfresh
  * #578 Request Window Attachment Image too large in viewer
    * Fixes a Bug that scales window too large after uplaoding a large image.

# metasfresh 4.43.42 (2016-45)

## Features
* metasfresh
  * #504 new filter in saldobilanz report
    * Added a new filter in saldobilanz report to exclude the year end accountings (profit & loss) from report.

* metasfresh-webui
  * #41 Implement Dashboard REST endpoint
    * Added a new REST-API endpoint for WebUI KPI widgets.

## Fixes
* metasfresh
  * #552 division by 0 in costprice report
    * Fixed a division by 0 Bug in costprice report.

* metasfresh-webui
  * #40 Account fields are not working
    * Fix in new WebUI Implementation. An exception occured because of Field Type account.

# metasfresh 4.42.41 (2016-44)

## Features
* metasfresh
 * #500 Migration: Create Requests for all inout lines with quality issues
   * SQL Migration Path for all Material Receipts with Quality Issues. Reclamation requests are created.
 * #514 Reclamations report: group the inouts with ff.
   * Create a new Report to analyze the Performance Issues in Vendor receipts/ customer deliveries. The report shows all details to performance issues (Quanitity-, Quality-, Delivery-, Receipt-Performance).

## Fixes
* metasfresh
 * FRESH-823:#536 Context bug in MLookup
   * Fixed a minor context Bug in MLookup Fields.
 * #540 Table and Columns - IsLazyLoading flag is not displayed
   * Fixed a Bug that occured in Table and Columns Definition, preventing isLazyLoading to be shown.


# metasfresh 4.41.40 (2016-43)

## Features
* metasfresh
 * #505 Possibility to define multiple Washing Testcycles for Carrots
   * Quality Assurance Feature for Long Term Storage vegetables. Prossibility to define Washing cycles and route  the Logistic Units to manufacturing Order.
 * #503 Beautify C_PaySelection_CreateFrom and C_PaymentTerm fields
   * Adding better descriptions for Parameters in Payment selection Process.
 * #412 Get rid of AD_Tab.OrderByClause
   * Adapting the sorting machanism in Tabs to allow Layout engines to receive precise Informations which columns are sorted. Initially needed for new WebUI.
 * #424 Migrate spring-boot from 1.3.3 to 1.4.x
   * Updated spring boot-from to to allow the usage of a recent elasticsearch version.

* metasfresh-webui
 * #27 Support for custom order bys in browseView
   * Added new Support for a custom order by criteria in grid-/ browse view.
 * #29 Adapt Invoice candidates window to webui
   * Adapted the Invoice Candidates window to WebUI.
 * #31 Implement document actions
   * Implemented the Document Action for the Web User Interface.
 * #32 Implement document references
   * Provided the Document References to embed these in navigation contex of each document.
 * #33 Implement document filters from AD_UserQuery
   * New and much easier Filtering criteria for data selections in metasfresh nextgen.
 * #20 Cache lookups
   * Optimize lookups content loading with cache functionality.

## Fixes
* metasfresh
 * #508 Creating User without Business Partner throws Exception
 * #487 Attribute editor dialog stores empty field as ''

# metasfresh 4.40.39 (2016-42)

## Features
 * #443 Add is to be sent as email to doc outbound log
 * #418 Improve sales and purchase tracking reports

## Fixes
 * #407 CCache always creates HashMap cache even if LRU was requested
 * #428 NPE when reversing an invoice including a product with inactive UOM conversion
 * #492 build issue with jaxb2-maven-plugin 1.6 and java-8
 * #483 Gebindeübersicht Report Typo fix
 * #482 Unable to issue certain HUs to a PP_Order
 * #494 R_Request new Request context missing

# metasfresh 4.39.38 (2016-41)

## Features
 * #388 make M_ReceiptSchedule.IsPackagingMaterial a physical column
   - Changing the Field in Material Receipt Schedule fpr Packing Materiel. Swapped from pirtual to physical column.


## Fixes
 * #448 Rounding issue with partical credit memos
   - Fixing a rounding issue which popped up after createing a partial credit memo for referenced invoice document.
 * #270 Purchase Order from Sales Order Process wrong Aggregation
   - Optimized the Purchase Order creation process from Procurement candidates. Purchase Orders are now aggregated properly when identical Vendor and products (and further details).
 * #433 C_Order copy with details: Packing Instructions are not copied
   - Fixed a Bug when using Copy with details in c_order. Packing Instructions are now copied too.

# metasfresh 4.38.37 (2016-40)

## Features
 * #395 Add Description in Jasper Invoice Vendor
   - Added a new row in to allow the display of optional line text in further invoices

## Fixes
 * #451 OCRB not available in JVM but needed for ESR page
 * #431 QtyTU does not update in wareneingang pos
 * #436 Single lookup/list value for mandatory field is not automatically set
 * #454 barcode field is reset after 500ms
 * #455 autocomplete in non-generic fields not working anymore

# metasfresh 4.37.36 (2016-39)

## Features
 * #302 Add different onError policies to TrxItemChunkProcessorExecutor
   - Added further policies for InvoiceCandidate processing.
 * #213 Add onhand qty to MRP Product Info
   - Added a new column in MRP Product Info to now show the Handling Unit Storage On Hand Quantity.
 * #375 Jasper: extend product name on report_details
   - Extension of name Field in Jasper Report (report_details).

## Fixes
 * #409 MRP Product Info might leave back stale entries after fast changes
   - Making sure that statistics in MRP Product Info are updated also after quick complete and reactivate of sales and purchase orders.
 * #387 Purchase Order generation in Procurement Candidates not to be grouped by user
   - Ensured that Purchase Order Candidates are aggregated to 1 Purchase Order per Vendor when triggered.
 * #370 Material Receipt - Somtimes double click needed for weighing machine
   - Fixing a bug that occured on certain Windows clients with connected weighing machines.
 * #420 NPE in CalloutOrder.bPartner
   - Eliminated a Null Pointer Exception in Sales Order Callout CalloutOrder.bPartner.
 * #410 sscc label org fix
   - Fixed a minor issue in SSCC Label to load the correct Orgabnisation and Logo when generated and printed.
 * #422 pricelist report do not show virtual HU
   - Fixed the pricelist report to also show virtual HU.
 * #331 Activating the trace log file doesn't always work
   - Stabilized the new trace log feature. Here switching on/ off visibility.
 * #437 Old window Produktion is opened automatically by menu search
   - Fixed the autocall in menu search.

# metasfresh 4.36.35 (2016-38)

## Features
 * #395 Add Description in Jasper Invoice Vendor
   - Added a new row in Vendor Invoice to allow the display of optional line Text.
 * ME-46 Support Ubuntu 16.04 server with metasfresh server installer
   - Milestone Feature: Provided a new metasfresh installer for Ubuntu 16.04
 * #369 request report
   - Provided an excel report for quality analysis bases on dispute request history and data.
 * #361 Request change for customer service
   - Added possibility for dispute requests
 * #377 Implement executed SQLs tracing
   - Admin Functionality to enable better Performance Tracking of SQL.
 * #338 Get rid of legacy NOT-EQUALS operators from logic expression
   - Getting rid of not-equals operators in logic expressions.
 * #333 All tables shall have a single column primary key
   - Change needed for metasfresh WebUI and Rest API. All tables used in WebUI/ Rest API shall have a primary Key.
 * #21 UI Style default for elements
   - WebUI Fallback Szenario for elements when UI Style is not explicitly set.
 * #20 Cache lookups
   - WebUI Performance tweak. Now allowing caching for lookups.
 * #18 Optimization of root & node requests.
   - Added limitCount to path elements to allow accurate results for Navigational structure in WebUI.
 * #16 Implement virtual document fields support
   - New functionality for WebUI to allow fields with content computed by Business Logic.
 * #14 Layout documentSummaryElement field to be used for rendering breadcrumb info
   - Added DocumentSummary support for breadcrumbs in metasfresh WebUI/ Rest API.
 * #13 elementPath should return path without element
   - Possibility to return path without leaf node.
 * #11 Implement grid view support
   - Awesome, new possibility to open Windows in grid view representation.
 * #10 implement documents filtering support
   - Providing metadata for filtering via RestAPI for example for grid view.
 * #9 provide precision for numeric layout elements
   - WebUI: Detailed precision funcionality for amount and costs/ prices elements.
 * #7 provide "grid-align" for layout elements
   - Generic alignment possibility via application dictionary used for metasfresh WebUI.
 * #24 Breadcrumb Navigation Plural caption
   - Added a plural caption for WebUI Breadycrumb navigation.

## Fixes
 * #411 missing index on C_OrderTax.C_Order_ID
   - Performance change. Adding index for c_ordertax.
 * #367 Invoice candidates invoicing Pricelist not found
   - Fixing a minor issue during invoiceing. Pricelist was not found under certain circumstances.
 * #380 duplicate lines in inout
   - Eliminating an issue when deactivating a product and adding another product with same EDI GLN.
 * #348 Sort tabs shall consider Link column and parent link column if set
   - Fixing issue considering link and parent column when sorting.
 * #330 Process's RefreshAllAfterExecution does not work when the record was moved
   - Eliminiating an issue when refreshing after execution of processes.
 * #327 Got NPE when completing a drafted order
   - Fixing a Null Pointer Exception when trying to complete a drafted order document.
 * #337 ERROR: duplicate key value violates unique constraint "c_bpartner_stats_c_bpartner_id_unique" triggered from some callouts
   - Fixing an exception when trying to select a BPartner without valid ship location in Sales Order.
 * FRESH-257 WI1 - rendering a window with tab, one field per field type incl. editor and fieldgroup
   - Initial WebUI Proof of Concept Task. A lot has already done since this one, even more to be expected.
 * FRESH-369 Change bpartner in order -> pricelist does not update
   - Fixing callout issue not updateing the correct pricelist whan changing a Business Partner in Sales Order.
 * #379 Included tab randomly not working in inout and invoice
   - Fixed a bug that ranomly prevented the correct rendering of included Tabs in Invoice window.
 * #12 Data not shown in SubTab
   - Adjusted the data defined in RestAPI for Subtab content.
 * #311 Payment Selection Exception when not able to find bpartner account
   - Added further Account seelection functionality to prevent Exception when selecting BPartner without Bank account.
 * #378 Bug in validation of field docsubtype
   - Eliminated an issue which apperared in Doctype Definition when selecting a DocSubtype.
 * #262 sales and purchase tracking
   - Minor tweaks and fixes in sales and purchase tracking Report.

# metasfresh 4.35.34 (2016-37)

## Features
 * FRESH-112 metasfresh web
   - Integrated recent backend related changes done for metasfresh REST API Implementation.
 * #359 document Note not displayed on invoice
   - Fixed the issue that c_doctype.documentnote was not shown properly on Jasper invoice documents.
 * #262 sales and purchase tracking
   - Implemenation of a large Sales and purchase Tracking Report inclusing possibility to export to excel.
 * #354 Rearrange unloading fields in Sales Order Window
   - Adjusted the validation- and display-rules in sales order window abould fields for unloading (Partner, Location).

## Fixes
 * #366 Faulty unique constraint on M_PriceList
   - Fixed a wrong contraint in M_Pricelist, that prevented creating Product-BPartner-Price-Combination with BPartner recorded on client level.

# metasfresh 4.34.33 (2016-36)

## Features
* #297 Performance problems related to zoom-to
  - Improved user experience, massively reduced loading times for generic zoom-to links in icon-bar.
* #249 Referenzliste in AttributeValue
  - Getting rid of Reference List (System) in client side Attribute Values.
* #347 change default docaction after complete
  - After eliminating all close docactions in permissions now changing the next docaction in document Workflow.

## Fixes
* #315 ReceiptSchedule.QtyToMove not properly updated on reopen
  - Fixed a Bug that prevented the correct update of ReceiptSchedule.QtyToMove after reactivating the record.
* #319 material tracking - deduplicate numbers in article statistics report
  - Getting rid of duplicated statistic qmounts in material Tracking report.
* #329 Revenue reports BPartner & Week show different amounts when HU Price
  - Fixing an issue in Business Partner Revenue Weeek Report that appeared with Usage of Transportation Units with multiple Customer Units in shipments.
* #340 Validation Rule in C_BPartner_Product for C_BPartner_ID wrong
  - Minor Fix of the Validation Rule in C_BPartner_Product. Now also allowing Businesspartners on Client Level.
* #351 translate order summary
  - The Order summary is now covered by translation.
* #335 Invoicing taking wrong Documenttype for Producer Invoice
  - Issue solved when changing the Parms for Producer Invoiceing in Business Partner after already having created Invoice Candidates.

# metasfresh 4.33.32 (2016-35)

## Features
 * #320 material tracking - provide excel friendly information view
   - New SQL report for material tracking

## Fixes
 * #299 Report "Leergutausgabe" from Window "Lieferantenrücklieferung"
   - Localized the empties Report so that one can now include alternative languages.
 * #315 M_ReceiptSchedule.QtyToMove not properly updated on reopen
   - The QtyToMove is now updated after reactivating/ reopening the Material Receipt Schedule.
 * #225 Allocation - Accounting 0,00 when Posted
   - Fixed further minor issues in reposting manchanism for Payment Allocations.
 * #277 Invoice candidates sums at the bottom are not considering org-assignment
   - Fixed an issue with Org Role Access in Window Invoice Candidates. Now the Status Row considers the Org Access Permission.

# metasfresh 4.32.31 (2016-34)

## Features
 * #276 Report Konten-Info new Parameter
   - Added new Parameters (VAT-Period from-to, Account No. from-to) to Account Information Report.
 * #273 Report "Anbauplanung" addition & adjustment
   - Adjusted  the Report for "Anbauplanung" to print out additional information.
 * #272 Report Karottenendabrechnung / Translate Headlines in Reportlanguage = FRENCH
   - Implemented the localization for the fresh produce invoice document.
 * #295 sql in purchase inout takes too long
   - Performance improvement in the jasper file.
 * #292 Automatically add reference no from purchase order to invoice candidate
   - The purchase order reference No is now automatically included in the corresponding invoice canidates.
 * #293 Create cron job for archiving the async-tables
   - Created a cron Job to automatically archive the async data. This speeds up the overall async Performance for large environments.

## Fixes
 * #251 Invoice Candidates double invoiced
   - Fixed a bug that seldomly appeared after invoiceing and caused that an invoice candidate could be invoiced twice.

# metasfresh 4.31.30a (2016-33a)

## Features
 - #297 Performance problems related to zoom-to
   * improve the documentation, both in that code and in the client

## Fixes
 - #298 ShipmentSchedule updating fails on missing UOM conversion
   * prevent an NPE on missing master data

# metasfresh 4.31.30 (2016-33)

## Features
 - #288 Problem with individual client log settings
   * outputting the individual log settings on user login to ease support

## Fixes
 - #275 In Picking HU Editor. New Flag ignore attributes for Filter
   * fixing some corner cases

# metasfresh 4.30.29 (2016-32)

## Features
 - #279 Set document type Bestellung as default value in purchase order
 - #275 In Picking HU Editor. New Flag ignore attributes for Filter
 - #283 Make Gebindesaldo Report support Multi Org

## Fixes
 - #255 Invoice candidates action bar is not considering org-assignment
 - #274 Purchase Order without BPartner Contact, Billto Contact wrong email
 - #252 Fix the code for ADR Attribute Retrieval
 - #243 C_Invoice_Candidate - Processed not always updated if IsToClear

# metasfresh 4.29.28 (2016-31)

## Features
 - #241 Excel Export for Open Items accounting currency
   * Adjusted the Excel Export of Open Items report ro show the sums in accounting currency.
 - #240 Consitency check page for Saldobilanz
   * Added a new Page in Salsobilanz report to allow quick consistency check of accountings.
 - #225 Allocation - Accounting 0,00 when Posted
   * Added a process which double checks the accountings of the day. If a document ist posted and the accounting results are 0,00 then a the document information is logged and the document is reposted.

## Fixes
 - #176 Bestellkontrolle add Promised Date
   * Added the Date promised onto report Bestellkontrolle.
 - #263 Delivery Conditions Flag sometimes not set in Procurement Candidates
   * Fixed a Bug that did not detect contracted lines in Procurement candidates if the contractline was not defined with given price.
 - #248 Admin Login when deleted properties
   * Adressed a security issue that allowed to gain admin permissions after deleting the client properties.

# metasfresh 4.28.27 (2016-30)

## Features
 - #201 KPI Accounted Documents
   * Created the logic for our new KPI "Accounted Documents" which will be included into our new metasfresh webUI.
 - #212 MRPProductInfo display Conference flag with sys config
   * Added a configuration possibility to be able to switch the conference flitering functionality on-off in MRP Product Info.
 - #226 show accounting currency in open items report
   * Implemented a counter check Open Items Reports (customer, vendor) with Accounting Balance. Open Items in foreign currency now show also the sums in accounting currency.

## Fixes
 - #153 PaymentRule = S in Invoice
   * Checked Code for direct setting of PaymentRule cheque got rid of it.
 - #220 Do not load pricelist and pricelist version  on login
   * Not loading Pricelist and Pricelist Version into context anymore during login.
 - FRESH-402 Procurement bidding
   * Minor jasper fix
 - #232 Separate c_flatrate_terms from the normal procurement and RfQ in procurement Excel
   * Separated the sums of procurement contracts vs. sums of RfQ biddings.

# metasfresh 4.27.26 (2016-29)

## Features
 - #152 Improvements in  counter documents view and window
   * Added different fields. Renamed fields for better understanding. Added different validation rules.
 - #173 Window Dunning Candidates - new Field DocumentNo
   * Included the Invoice Document No. in Dunning Candidates window.
 - #183 Error in material tracking if one partner has two contracts (with different conditions) for the same product
   * Skipping a number of unneccesary things if an invoice candidate's `Processed_Override` value is set to "Y"
 - FRESH-402 Procurement bidding
   * Adding jasper file for the procurement documents
 - #181 Customer specific Lieferschein without Price
   * New Jasper Shipment Document that does not show the prices for each line.

## Fixes
 - #216 Accounting: Invoice grand total Fact_Acct line was not found
   * Fixed a Bug in accounting of Allocation Header that appeared in certain circumstances when writing off paid amount completely.
 - #100 EDI wrong handover location in Picking Terminal
   * Sales Orders created via EDI Import could have the wrong handover Locations in a certain condition. This wrong Location appeared in Picking Terminal. Fixed this.
 - #174 Report Konten-Information empty c_activity_id
   * Added a new Flag in Report Parameters to show all entries which have a empty c_activity_id.
 - #203 Payment writeoff not possible for Incoming Payment
   * Fixed a Bug that prohibited the writeoff in incoming Payments.
 - #175 C_Invoice_Update_PaymentRule
   * Changed Lagacy Code that set the Payment Rule to cheque.
 - #210 product appears twice in invoice print preview
   * Minor Bug in Jasper Document that printed out the wrong quantity and total for an invoiceline when shipment quantity was 0 and the invoiceline was aggregated with more than 1 shipment.
 - FRESH-529 drop qtyreserved from product info
   * Dropped the column qtyreserved from product info window.

# metasfresh 4.26.25a (2016-28a)

## Fixes
 - #204 FRESH-525 db_columns_fk view is not working correctly anymore
 - #194 FRESH-517 Jasper Report Error: java.net.BigDecimal
 - #158 FRESH-495 Make de.metas.fresh.printing.spi.impl.C_Order_MFGWarehouse_Report_NotificationCtxProvider thread safe
 - #202 FRESH-522 Payment-in-out-allocation buggy when partial allocation
    * Fixed the newly introduced Feature about allocating 2 Payments (in-out) in cornercase with partial allocated Payments.

# metasfresh 4.26.25 (2016-28)

## Features
 - #182 FRESH-510 Report "Wareneingangsbeleg" with Information "1." / "2. Waschprobe" ergänzen
    * Small layout-change and additional field for quality inspection. Thanks to our new contributor @Spavetti
 - #185 Fresh-512 Receipt POS - sometimes gets wrong numbers from weighting machines
    * Additional glasspane implementation to avoid uncontrolled button activations during the wighing process in Material receipt. Extended logging of weighing information.
 - FRESH-402 Procurement bidding
    * Major new Feature allowing an efficient Procurement Request for bidding workflow, including the extended Procurement bidding web application and automated creation of procurement candidates for selected winners.
 - #119 FRESH-455 different email per org in inout print preview
    * Possibility to define and use different eMail adresses for InOuts, depending on document Organization.
 - #142 FRESH-479 C_AllocationHdr.C_AllocationHdr_ID: Loader too many records
    * Changed the Fieldreference in Subtab to Search-Field to improve opening Performance.
 - #150 FRESH-492 Fix implementation for BPartner Statistics
    * Refactoring, code improvement
 - #128 FRESH-465 Extend Record_ID Column Implementation
    * Extended the Record_ID column Feature to allow more than 1 generic table-record-button to jump to referenced Dataset.
 - #145 FRESH-482 Don't log migration scripts if the transaction failed

## Fixes
 - #197 FRESH-519 Payment void or reverse correct
    * Fixed a Bug that could occure when trying to void or reverse-correct a Payment Document.
 - #151 FRESH-491 When creating a new organization, don't create org access for System role
    * Now we don't automatically create an Org Access for System Role anymore.

# metasfresh 4.25.24a (2016-27a)

## Features
 - #162 FRESH-499 modernize the server's index.html
    * Adjusted the index.html to upgrade of metasfresh to Java 8 usage.
 - #139 FRESH-475 Check for java8 in the rollout-scripts
    * Adjusted the rollout scripts of metasfresh to Java 8 usage.

## Fixes
 - #123 FRESH-460 Users find window name "window, tab, field" confusing
   * also updated menu items
 - #147 FRESH-484 Error creating manual DD_Order
 - #148 FRESH-485 de.metas.async.api.<WP-Name>.AD_User_InCharge_ID can't be overriden on org level

# metasfresh 4.25.24 (2016-27)

## Features
 - **FRESH-399 Upgrade to java-8**
    * Existing users, please see [this howto](http://docs.metasfresh.org/howto_collection/Wie_aktualisiere_ich_die_Java_Version_auf_meinem_server.html) for instructions on how to update your metasfresh server
 - FRESH-397 Upgrade to JasperStudio and latest jasper version
    * Update of Reports and Documents in metasfresh to use the latest Jasper Studio and Jasper Reports Version. Updating to jasperreports-6.2.1
 - #136 FRESH-472 Sequence on Org for more than 1 Doctype
    * Enhancement of Document Sequence seperation among different Organisations. Implemented so that Organisations may uses same Doctypes but seperated Doc Sequences.
 - #90 FRESH-417 Create view and window to identify missing counter documents
    * Implemented View to allow check if counter Documents are missing.
 - #132 FRESH-468 Excel Export of report Konten-Information not working
 - #123 FRESH-460 Users find window name "window, tab, field" confusing
    * Adjusted Name of Window "Windows, Tabs and Fields"
 - #124 FRESH-461 Role "System Administrator" is disabled
    * Note: Not a "fix" because we deliberately deactivated it before and now find that the normal user is better off with the role being available.
 - #125 FRESH-462 enable all entity types
    * Not a fix, the reasoning is similar to #124

## Fixes
 - #137 FRESH-473 Glitches running metasfresh out of eclipse
    * adding a lauch config to run the client with embedded server
    * removing a not-needed dependency that might not be available
    * ignoring local activemq data
    * thx to @pmaingi for going through them with us

# metasfresh 4.24.23a

## Features
 - #121 FRESH-457 Make recipient of the mail configurable in Process SendPDFMailsForSelection

## Fixes

# metasfresh 4.24.23

## Features
 - FRESH-378 process to close invoice candidates
    * New Feature in Invoice Candidates Window which allows the mass manipulation of records setting these to "processed". Also checking and updating referenced shipment candidates during this workflow.

## Fixes
 - #118 FRESH-454 Dont create InvoiceCandidates for DocSubType Saldokorrektur
    * Changed InOut Handler to not create Invoice candidates when DocSubType is "Saldokorrektur".
 - #104 FRESH-441 Notification bar in Material Receipt (POS) covers OK Button
    * Moved the Notification Bar slightly up, so the OK Button, Cancel Button and Changelog Link is not covered anymore.
 - #107 FRESH-445 Awkward eMail encoding in Swiss language
    * Simple Fix to ensure the right encoding when sending eMails.
 - FRESH-280 Period sorting in all Dropdowns where uses year-month numeric
    * Fix related to Order by of Calender and Periods in all relevant Dropdown Lists.
 - #105 FRESH-442 Annotated model interceptor
    * Annotated model interceptor with timing after delete and ifColumnChanged does not work correctly. Fixed.
 - FRESH-438 Make MRP Product Info Work
    * Removed stale data and added FK-constraints and improved logging to avoid Null Pointer Exception
 - FRESH-306 Customer alloc with Vendor Payment: Wrong Accounting
    * Adjusted the accounting of the Alocoation of Incoming and Outgoing Payments.

## Documentation
 - FRESH-323 metasfresh Developer Documentation
    * Added some clarifications and described how to import the initial DB-dump

# metasfresh 4.23.22a

## Features

## Fixes
 - FRESH-408 Picking Issue

# metasfresh 4.23.22

## Features
 - FRESH-280 Period sorting in all Dropdowns where uses year-month numeric
    * Changed sorting for all Dropdown entries about Periods (Month-Year) to have order-by year-month numeric desc

## Fixes
 - FRESH-412 quick input in orders not working
    * Fixed an issue in Quick order entry in Orders (sales and purchase) window
 - FRESH-409 Creating Partner Relation throws Exception
    * Fixing an exception that appeared when creating and saving a Business Partner relation
 - FRESH-407 M_ShipperTransportation Terminated after complete
    * Fixing an exception that popped up when completing a shipper transportation document
 - FRESH-339 Order Candidates BPartner Change does not effect Delivery Adress
    * Introduced additional callout to adjust the corresponding locations when choosing a different Business Partner in Order Candidates Window
 - FRESH-279 DD Order CU calculation wrong when TU = 1
    * Adjusted the Qty CU Calculation when TUQty is 1
 - FRESH-309 Missing ADR ASIs in purchase order lines since february
    * Restored attribute set instances that might have been missing in the past on some systems
 - FRESH-386 another error when sales order is automatically created as counter doc from a purchase order with packagings
    * Fixed error that appears in sales order counter document because of automatic Handling Unit generation in complete.
 - FRESH-388 Invoice Candidates not updated for some material receipts
    * Introducing a view to assist support troubleshooting

# metasfresh 4.22.21

## Features
 - FRESH-275 Search Field in Role _Access Windows with autocomplete
    * In Window Role, allow the user to search and autocomplete Windows, Processes, Forms and more, instead of using a dropdown list. This Functioanality allows a faster creation of Permission rules.
 - FRESH-349 KPI: Printing Performance
    * Adding a window to show per-shipment performance. This will help to understand if printing performance changes over time.
 - FRESH-350 check if purchase inout label and print preview can run faster
    * Improving Performance of material Receipt Labels in Print Preview and Printing.
 - FRESH-377 make invoice print preview faster
    * Improving Performance of Purchase- and Sales-Invoice Document in Print Preview and Printing.
 - FRESH-383 make orders print preview run faster
    * Improving Performance of Purchase- and Sales-Order-Document in Print Preview and Printing.

## Fixes
 - FRESH-400 Cut off in invoice jaspers
    * Header Label for UOM was cut off in Invoice Document. Fixed.
 - FRESH-344 Move KPI SQL to repository and new DB Schema
    * Fix: KPI SQLs were in the default/public schema
 - FRESH-356 make logo work for any org

## Documentation
 - Creation of HowTo's
    * You can now find a quickly growing Set of HowTo's in our metasfresh documentation Project. Check the details here : <a href="http://metasfresh.github.io/metasfresh-documentation/">http://metasfresh.github.io/metasfresh-documentation/</a>

# metasfresh 4.21.20

## Features
 - FRESH-349 KPI: Printing Performance
    * First step in creating queries for printing performance analysis. In near future these queries will be part of an administrator Dashboard and show average Printing performance for different documenttypes.
 - FRESH-344 Move KPI SQL to repository and new DB Schema
    * Moving all prepared KPI Queries to an own Database Schema called de_metas_fresh_kpi.
 - FRESH-347: Relation type between PMM_Purchase_Candidate and C_Order
    * Create an AD_relationType between PMM_PurchaseCandidate and C_Order.
 - FRESH-352 Colored Bar
    * Extending WindowHeaderNotice to also allow setting the notice's foreground and background color. Extending WindowHeaderNotice to also allow setting the notice's foreground and background color. Requirement to be able to create a different color Bar in metasfresh, so visually seperate Logins from different Organizations.
 - FRESH-342 Shipments not created
    * Made the shipment schedule enqueuer's doings more transparent to the user. Also added a house keeping tasks to reenqueue stale shipment schedules.

## Fixes
 - FRESH-374 duplicates asi in purchase inout print preview
    * Fixed a minor issue in Jasper Layout for meterial receipt document.
 - FRESH-363 Client metasfresh not getting results from server due to cxf bug
    * Workaround: Never log incoming payload with JMS transport until https://issues.apache.org/jira/browse/CXF-6930 is solved.
 - FRESH-358 Producer Invoice: Jasper Document shows Recapitulation for technical Tax
    * Fixed a wrong display of special Tax for Urproduzenten in Switzerland.
 - FRESH-360 EDI files occasianally still have wrong encoding
    * Fixed occasionally apperaring wrong encoding in EDI communication.
 - FRESH-356 make logo work for any org
    * Possibility to show the Logo on Jasper Documents. The Logo is taken from Organisation or Businesspartner joined to Org-ID.
 - FRESH-351 Error when sales order is automatically created as counter doc from a purchase order with packagings
    * Solving an issues which appeared in usage of counter documents, because of not matching packagings in each Organisation.
 - FRESH-348 purchase orders created with wrong IsTaxIncluded value
    * Ensuring that whenever the price list changes in an order, IsTaxInCluded, M_PricingSystem_ID and C_Currency are updated.

## Documentation
 - GROWTH-65 Community and Legal Files
    * Added LICENSE.md, CODE_OF_CONDUCT.md and modified The Contributing Guidelines.

# metasfresh 4.20.19

## Features
 - FRESH-254 Customer-Vendor Returns manual flag
    * Set the "manual" flag's default to Y in vendor and customer return windows allowing a more efficient recording.
 - FRESH-334 Product BPartner Contraint Issue
    * Prevent the user from accidentally creating C_BPartner_Product record whose AD_Org_ID makes no sense.
 - FRESH-326 Set the Correct Org in Fact_Acct_Summary
    * changed the migration script to be more repeatable

## Fixes
 - FRESH-152 Extract statistics fields from C_BPartner and put them to a new table called C_BPartner_Stats
    * Fix to avoid multiple updates of same statistical value.
 - FRESH-343 Unwanted PInstance log shown after olCands were cleared for processing
    * Took out changelog for Orderline Candidates which were cleared for processing.
 - FRESH-314 Foreign BPartner reference included in sales order C_Order.C_BPartner_ID.
    * Some polishing around AD_ChangeLog creation.

# metasfresh 4.19.18

## Features
 - FRESH-335 create an initial contributor's guideline
    * Initial Setup of Contributing Guidelines. Further improving.
 - FRESH-278 Umsatzreport Geschäftspartner copy and modify details
    * Created an new Report for Turnover. Data of Report now depending on Delivered Quantities and value.

## Fixes
 - FRESH-338 Async not running
    * Fixed an additional problem with creating AD_ChangeLogs
 - FRESH-314 Foreign BPartner reference included in sales order C_Order.C_BPartner_ID
    * fixed a problem with creating AD_ChangeLogs
 - FRESH-311 Packvorschriften from different Org shown in Leergut
    * Make sure that the Empties Return Window only shows Packing Material that is defined in Logged in Organisation.
 - FRESH-333 Procurement candidate prices not updated correctly
    * Solved an Issue in Proce Calculation of Procurement Candidates when New Pricelist was created for already existing Procurement candidates.
 - FRESH-307 New Organisation: Financial Data of existing Org
    * Make sure that Financial Reports only show Data from selected Organisation.
 - FRESH-326 Set the Correct Org in Fact_Acct_Summary
    * Bug with AD_Org_ID not properly set in FACT_ACCT. Solved the Issue and Created Migration Script for Old Data.
 - FRESH-331 Double click needed for weighing machine and occasional NPE
    * Improved logging and making the application more robust
 - FRESH-329: periods missing in dropdown because of no translations
    * Fixed an Issue with Calendar Periods. These were  not shown because of missing Translations.
 - FRESH-327 Subsequent change of logo not working correctly without cache reset
    * Fixing an issue with Caching of Logo. Cache was not resetted after changing the Logo in running Client Session.
 - FRESH-312 Project cannot be compiled when downloading from github directly
    * Removed references to our internal maven repo, fixed a wrong groupid and provided a public keystore for development purposes.
 - FRESH-302 make inout print preview faster
    * Improved the Performance of Print Preview of In-Out Jasper Documents.

# metasfresh 4.18.17

## Features
 - FRESH-314 Foreign BPartner reference included in sales order C_Order.C_BPartner_ID
    * We could'nt reproduce this issue. We improved AD_ChangeLog to also log server-side changes (which have no session-id) and also store the AD_Pinstance_ID if available. If it happens again we will be will be able to trace it.
 - FRESH-320: Swing UI: License aggrement popup shall have an icon down in task bar
    * Adding an Icon in License agreement popup.
 - FRESH-278 Umsatzreport Geschäftspartner copy and modify
    * Adding a revenue report that is week-based and also based on the delivered quantities. The original revenue report still exits, but is based on invoiced quantities instead.
 - FRESH-305 Reduce Warehouse Dropdown List in Wareneingang (POS)
    * After selecting the source warehouse in Wareneingang POS, check all the Distribution Network Line entries that have this specific warehouse as source and provide the Target Warehouses for selection in Target Warehouse Dropdown List.
 - FRESH-312 Project cannot be compiled when downloading from github directly
    * Adding 3rd-party jars that are not available from the standard maven repos to a github hosted repo. Thanks a lot to @mckayERP and @e-Evolution for pointing us to the issue.
 - FRESH-228 Change jxls-poi version from 1.0.8 to 1.0.9 when it will be released
    * Updated to jxls-poi 1.0.9
 - FRESH-302 make inout print preview faster
    * Improved the InOut Print Preview Performance. Is now nearly 50% faster as before.
 - FRESH-298 Setup Printing Dunning Docs to separate tray for ESR Zahlschein
    * Adjusted the layout of Jasper Dunning Documents to better match pre-printed paper without having to use calibration.
 - FRESH-304 Report Konten-Information Rev+Exp accounts Saldovortrag year end
    * Switching the Report "Account -Information" to automatic Year-End initialization of Revenue and Expense Account balance.

## Fixes
 - FRESH-318 ESR String Processing not working with multiple partner bank accounts
    * C_PaySelectionLine: combining two methods into one, to avoid duplicate effort and FUD with their execution order.
    * making sure that annotated model interceptor methods are ordered by their method name
 - FRESH-251 Inout created from Picking-Parm shall only have picked Qty LU-TU too
    * The creation of InOuts shall consider the Picked Quantities of LU-TU via Picking Terminal, when Inout Creations is done from Inout-Candidate Window with Parm PickedQty = 'Y'.
 - FRESH-300 client not starting when config is not completed
    * Fixed a Bug that appeared in Client/ Org Setup when this initially was cancelled or not completed.
 - FRESH-152 Extract statistics fields from C_BPartner and put them to a new table called C_BPartner_Stats
    * Additional Fix.
 - FRESH-93 Purchase Order 848092, Row Missing in Invoice Candidates
    * Extending/ fixing the views to also find wrong Quantity ordered from Inout Lines referencing Invoice Candidates.
	* adding the ddl to our repository

# metasfresh 4.17.16

## Features
 - Fresh 271 Allow easy and riskless experimental builds
    * DevOps - we can now build the complete metasfresh distributable for an issue branch, without artifact GAV collisions
    * Some changes in the buildsystem that allow us to build and rollout feature branches before they were integrated.
 - FRESH-265 Procurement Candidates: Packvorschrift overwrite
    * Possibility to Overwrite the default Packing Instructions/ Handling Units for a reported Product Quantity. The Repor Informations come from Procurement Application.
 - FRESH-286 jenkins envInject plugin overwrites BUILD_URL value
    * DevOps - introducing a new environment variable ROLLOUT_BUILD_URL to be set by the caller. Fallback to BUILD_URL if the new var is not set.
 - FRESH-203 Procurement: Mail in BPartner language, other eMail Address
    * CRM - Enhancing and extending mail configuration and functionality to select an eMail configuration by document type or base type.

## Fixes
 - FRESH-203 Procurement: Mail in BPartner language, other eMail Address
	* Fixed the formatting and encoding problem in the mails sent by our async processor

# metasfresh 4.16.15

## Features
 - FRESH-259 Completely remove zkwebui from metasfresh
 - FRESH-261 Create simple process to change the hostname of a device configuration
    * adding a simple DB function to do the job for now

## Fixes
 - FRESH-267 aparently Loglevels are changed somewhere in the code
 - FRESH-270 material tracking: total received qty and scrap sometimes missing on invoice
     * fixed a problem where those two invoice detail records were attached to a not-displayed group
 - FRESH-234 report sales inout qtys for products and TUs are not alligned

# metasfresh 4.15.14

## Features
  - FRESH-245 filter columns in procurement for year as well
     * Possibility to hide also the columns filtered by year in Excel Reporting. Here especially done for Procurement contract report.
  - FRESH-152 Extract statistics fields from C_BPartner and put them to a new table called C_BPartner_Stats
     * Moving the Business Partner Status out of C_BPartner Data structure into C_BPartner_Stats. This was we avoid performance and blocking issues when updateing the Business Partner statistics.
  - FRESH-252 New Field datePromissed in Invoice Candidates Window
     * User Requirement for selecting Service Data to be invoiced via Invoice Candidates Window. Now the User has the possibility to also filter rows which are not triggered by an Inout Document.

## Fixes
  - FRESH-234 report sales inout qtys for products and TUs are not alligned
     * Minor Layout change for customer individual Inout Documents (Alignment of  identical Column headers on same Page).
  - FRESH-249 hubalance general report missing TU when no carry
     * Small fix in Handling Unit Balance Report.


# metasfresh 4.14.13a

## Features

  - FRESH-206 metasfresh server informs the procurement webui server about what supplies were synchronized
     * when data is received by metasfresh, it now asynchronously sends back a confirmation to the procurement UI. This way it is possible to monitor the procurement webUI for supply reports that were not yet received by the metasfresh system , e.g. due to internet problems.
  - FRESH-187 Filter date-from and date-to in procurement excel
     * also fixing a problem that the library-version we use only supports a hardcoded 50 columns
  - FRESH-218 Create archives in partner's language
     * adding language info to archive records, so when mailing the PDF, the system can choose a mail template in the correct language

## Fixes
 - FRESH-235: User to Role assignment not working with some postgres versions
    * Fix of sql alias Issue. Recognized in User to Role Assignment.
 - FRESH-191 Procurement Excel: Although received no qties does not show
    * Fixed Issue. The quantities were not shown correctly in Procurement contract Excel Report.
 - FRESH-220 Autocomplete does not work if the underlying table has translated columns
    * Fixing the Issue with autocomplete not working whan the underlying table has translated columns.
 - FRESH-210 Org Name not updated after setting different name in Set Up Wizard
    * Using the SetupWizard, the Org name was not updated correctly.
 - FRESH-213 Process panel's Back button not working
    * Fixing an Issue with the back Button in Process Panel.
 - FRESH-222 QtyDelivered not updated for PMM_Balance
    * The PMM_Balance was not updateing QtyDelivered for contracted PMM_Products correctly. Fixed this Issue.

# metasfresh 4.14.13

## Features
 - FRESH-87 Log the JSON-Packages that are exchanged between the service endpoints
    * enabling the cfx LoggingFeature so we can log the data that comes in or goes out via jax-rs
 - FRESH-196 Procurement WebUI: Initially open with tomorrow
 - FRESH-197 Procurement WebUI: firefox's remember password does not popup
 - FRESH-176 Procurement WebUI: Allow switch enabled users between BPartners
 - FRESH-186 change gebindeubersicht to show all until selected date
 - ME-30 09951 Move code to github (108691256234)
	* switching from our internal mercurial server to actually work with and on github
 - FRESH-183 Price editable in Procurement Candidates
 - FRESH-97 Improve metas fresh server and client logging
 - FRESH-59 09915 procurement conditions jasper process (109344045046)
    * finetuning
 - FRESH-59 09915 procurement conditions jasper process (109344045046)FRESH-59 09915 procurement conditions jasper process (109344045046)
    * adding french translations
 - FRESH-172 Procurement: Double entries in PMM_Product: adding unique constraint after having cleaned up

## Fixes
 - FRESH-241 Get rid of com.verisign together with all those legacy payment processors
 - FRESH-215 Procurement WebUI language not updated when changed in bpartner
 - FRESH-219 Procurement: Contract missing in Procurement webUI:
    * making queue subscriptions durable to make sure data is not lost if a subscriber is not present
 - FRESH-205 Doc Outbound: eMail sent not updated
    * the EMail-sent counter is now correct
 - FRESH-219 - Procurement: Contract missing in Procurement webUI
    * adding JMX operation to send all contracts to the webui
 - FRESH-216 Error creating InvoiceCandidates for PP_Orders without issued quantities
    * the system now deals more graciously with material tracking PP_Orders that have receipts but no issues
 - FRESH-194 Picking: Uncompatible CU-TU Issue
 - FRESH-179 Remove customer specifics from jasper and DB functions
 - FRESH-193 problems after temporary JMS link outage
 - FRESH-184 Saldobilanz report year switching saldo for R+E Accounts
 - FRESH-176: Allow switch enabled users between BPartners
 - FRESH-160 Fix Report "Gebindesaldo all"
 - FRESH-177 MRP Product Info Window with empty columns: removing obsolete DB-functions
 - FRESH-37 09955 excel Report Procurement Statistics (105226320154)

# metasfresh 4.13.12

## Features
 - FRESH-70 Model interceptor to prevent deactivating PMM_Products that are unter contract
    * and making sure that activating a record is still allowed
 - FRESH-170 Laufender Vertrag, show Lieferprodukt also on Tab "Liefersatz"
 - FRESH-168 Procurement: Support logon for vendors with no contract
 - FRESH-86 Procurement Show aggregation of reported Qty in MRP Product Info
    * adding a column for the (offered) vendor supply quantity to the MRP product info window
 - FRESH-134 Make syncing on the webUI side more robust
    * refactored how we import the data, make it fail only bpartner level, product level
 - FRESH-139 webui log: show user's ip address and email as part of the log line
 - FRESH-141 Procurement: Procurement Candidates initial qtyToOrder 0
 - FRESH-128 Provide Basic CRM Features
    * adding a simple table to the business partner window that displays related documents etc in cronological order
 - FRESH-71 - extend metasfresh and provide Product-TRLs to the webUI
    * exposing a JMX operation to push all products and translations to the webUI

## Fixes
 - FRESH-171 fix qtyPlanned in procurements excel
 - FRESH-55 Add ASI-support to procurement contracts
    * fix: not all UOMs were eligible anymore
 - FRESH-167: Procurement: Provide Trend also when qty reported = 0
 - FRESH-164 Procurement: multiple Purchase Candidates after reporting qty for same day
 - FRESH-129 contact email in jaspers only after setting the user created as sales contact
 - FRESH-93 Purchase Order 848092, Row Missing in Invoice Candidates
    * adding an SQL based process that allows us to identify, fix and log occasional stale ICs
 - FRESH-126 Procurement WebUI: Qty 4 digits needed
 - FRESH-108 Fix Summary in C_Flatrate_Term_Create_ProcurementContract
 - FRESH-132 Assumption failure when trying to change the payment method in an invoice
 - FRESH-119 Setup wizard does not update field C BPartner Location.address
 - FRESH-125 Default User Record is on Wrong Org *
 - FRESH-30 09628 Procurement vendor-webUI purchasing and contract management
    * make sure that a PMM_Product can't be deactivated if it is part of a contract

----------------------------------------------------------------

# metasfresh 4.12.11

## Features
 - FRESH-82 Adapt PMM Balance reports to respect our new aggregations
 - FRESH-95 Modify the report C_Flatrate_Term_Create_ProcurementContract
    * now displaying the PMM_Product's Name which can also contain ASI-Information
 - FRESH-55 Add ASI-support to procurement contracts
 - FRESH-71 extend metasfresh and provide Product-TRLs to the webUI
 - FRESH-81 PMM purchase candidate: qty aggregation this/next week shall be on BP, product, ASI but NOT hupiitemproduct
 - FRESH-83 webui: another button called "Info" which displays a plain text which was configured in metasfresh

## Fixes
 - FRESH-78 In webui user is reporting in Qty CU and not Qty TU
 - FRESH-108 Fix Summary in C_Flatrate_Term_Create_ProcurementContract
 - FRESH-115 09933 InvoiceCandidates not created - Deadlock
    * had to revisit the task and fix some more

# metasfresh 4.11.10

## Features
 - FRESH-47	Don't create oracle migration scripts
    * removing another legacy piece of code
 - FRESH-37: 09955 excel Report Procurement Statistics (105226320154)
    * now using a high level excel templating engine (jxls)
 - 09961 MRP Product Info row selection persistency (109095061891)
    * when switching between days and filter settings, the selected row remains the same (if is is still there with the new filter settings)
 - when implementing a process, it is now possible to specifiy which record shall be selected after the process is executed
 - 09915 procurement conditions jasper process (109344045046)
    * now also supports contracts that have quantities, but no prices
 - 09628 procurement management (106716240958)
    * all changes in products, partners, contracts etc are now directly pushed to the mobile webUI
 - 09931 Bootify metasfresh (100627676679)
    * metasfresh now runs with spring-boot (server and client)
	* also replacing the JUL-based CLogger with slf4j

## Fixes
 - 09844 Login Problem: Client level Mandant and Org for System Administrator (102554242797)
 - 09915 procurement conditions jasper process (109344045046)
    * fix related to the contract start and end dates
 - usability fix in VNumber: first key press was lost
 - 09945 Pricelist for french customer - excel export not in customer language (107056752126)
 - 09944 Performance: Inout Reactivate-Complete taking too long (107539809839)
 - 09502 quality inspection (100925494419)
    * the final settlement invoice didn't have the correct witholding amount

## Instructions
 - When updateing an existing instalation, the script minor_remote.sh will stop.
   Please read the instructions to update your instalation to the new JBoss free version.


# metasfresh 4.10.9

## Features
 - 09915 procurement conditions jasper process (109344045046)
    * adding jasper, so that a procurement contract can be printed and singned by the vendor
 - 09924 Remove legacy oracle drivers and code (107845685842)
 - 09925 Create Balance Sheet Jasper (107146104064)

## Fixes
 - 09844 Login Problem: Client level Mandant and Org for System Administrator (102554242797)
 - 09939 Inconsistent ASI in InOutLine (109676742143)
 - 09922 null in tageslot sscc etikett (100681187457)
 - 09923 sepa export npe (106359694025)
	* if a given bank account info has no aasociated bank, we now give an informative error message
 - 09933 InvoiceCandidates not created - Deadlock
    * now we generally try processing a work package on deadlock.
 - Fixing NPE when invoicing failed *and* the user in charge had no C_BPartner

# metasfresh 4.9.8b

## Features
 - 09628 procurement management (106716240958)
    *  working on having metasfresh also talking to the webUI and communicate various changes instead of just responding to requests
 - FRESH-21: 09848 enable metasfresh to provide jax-rs services (101763395402)
    * when the client inititally starts and tries to connect the server, the timout is reduces from 1 minute to 2 seconds, to not stall the client and give quicker feedback if there is a problem with the server

## Fixes
 - 09628 procurement management (106716240958)
    * the first event was created with AD_Client_ID=0 and was therefore not processed

# metasfresh 4.9.8

## Features
 - 09920 Support sending invoice without an order via EDI: send the invoice's POReference if there is no cctop111 record coming from metasfresh
 - 09628 procurement management (106716240958)
	* the procurementUI communicates with metasfresh via jax-rs on a jms transport
	* support for the procurementUI to run an embedded broker and connect to metasfresh's broker over SSL
	* metasfresh contains a list with goods that are avaiable to be supplied by any vendor (without contract)
	* supply notes from the UI are sent to metasfresh and are shown to the metasfresh user as purchase order candidates which can directly be transformed into purchase orders
 - 09910 extend sql rollout tool to first create a new db from template (100074461801):
    * extending the tool so we can start by creating a new database from a templated-DB and then apply the scripts to that new database

## Fixes
 - 09912 AD EntityType ID is not acquired from project ID server (106063434593)

# metasfresh 4.8.7

## Features
 - 09628 procurement management (106716240958)
     * still a work in progress
	 * standalone procurement web application that is optimized for mobile and communicated with metasfresh
	 * procurement management in metasfresh
	    * manintain vendor contracts
		* create purchase orders for the supplies reproced via the web app
  - FRESH-21: 09848 enable metasfresh to provide jax-rs services (101763395402)
    *Moved and extended the AD_JavaClasses framework
    *Removed javax.jnlp (it was only needed because there was some code wrt WebStart,
     but that's not done anymore)
    *Removed javax.ejb (we now use jax.rs for the invokations)
     CConnection now also uses a proxy provided by jax-rs to query the application
     server state
     The next step can be to change jboss for a less old & heavy environment,
     like tomcat or something else
    *Extracted de.metas.event's JMS coded into de.metas.jms, because it's now also
     used by de.metas.jax.rs
    *Added table AD_JAXRS_Enpoint to manage our endpoints
    *moving replication and metas-esb folgers into a new ad_menu folder called
     "communication". Also moving the new AD_JAXRS_Enpoint windo to that folder
    *Changed startup-behavior so that when running in embedded-server-mode, the
     client always starts a local jms broker and also connects to it

## Fixes
 - 09643 Zahlung und Zahlung-Zuordnung Datum unterschiedlich (108395556223)
 - 09894 take email address on inout from contact and not properties (108765877478)
 - 09901 Report for packaging material balance: recap differences
 - 09890 Manual Fixing of voided Bankstatement after ESR Import (108847010077)
    * when a bankstatement is voided, all ESR import lines (if any) are unlinked from the bank statement

# metasfresh 4.7.6

## Features
 - FRESH-28: 09869 Enable subscription contracts (104949638829)
    * re-enabling a on-the-fly creation of subscription contracts with automated regular deliveries (via shipment schedule, of course).
	  We implemented this some years ago, but it was in use only briefly, so in this task, adapt and polish the old code.
 - 09859 Fix open items report - the whole query shall go in the reporting function (103228618621)
    * refactored the reports to be more maintainable and easier to support
 - 09766 VAT codes (107418136945)
    * new accounting report centered on VAT codes

## Fixes
 - 09862 Report Footer missing in inout jasper from Wareneingang POS
 - 09861 Error ESR Import with Partner that has Value bigger than 1000
 - when creating an accounting fact_acct for a C_BankStatementLine_Ref, we now set the fact_acct's C_BPartner_ID correctly
 - 09643 Zahlung und Zahlung-Zuordnung Datum unterschiedlich (108395556223)
    * when allocating an invoice with a payment, we now use the later date of the two documents in that allocation

# metasfresh 4.6.5

## Features
 - 09873 translate all of the metasfresh UI to english (105052594715)
    * translated more than 300 window, tab and field names that don't exist in adempiere and therefore weren't translated in task 09847

## Fixes
 - adding an index to C_InvoiceTax to solve a performance issue

# metasfresh 4.5.4

## Features
 - 09863 add comment to SQL generated by Jasper reports to identify (102778506388)
    * with this feature we can now see which running query belong to which jasper report
 - 09836 Show on HU-Receipt label if a HU was flagged for quality instpection (104096142493)
 - 09833 Show additional infos in print problem notification (105117588718)
    * extending the API to allow addtional context info to be added to a notification
 - FRESH-22: 09847 Import adempiere terminology as english trl into metasfresh (107370493155)
    * imported current en_US language translations from adempiere ERP
 - 09824 use locking API to prevent concurrent doc action on the same document (100066000843)

## Fixes
  - FRESH-22: 09847 Import adempiere terminology as english trl into metasfresh (107370493155):
     * fixed a bug in metasfresh that prevented to select the language by its name
      (just its value would have worked) as soon as "English" is available
 - 09776 EDI - Receiver without ORDERS (100584995833)
    * allow to distinguish between Edi-ORDERS and Excel files and allow both kinds to be processed in an EDI fashion
 - FRESH-20: 09661 Statistik für monatliche Lagermeldung - grouping per Product and ASI (106566269211)
    * fix for some quantities being counted multiple times
 - 09852 ESR-Import allow importing with invoice-partners that have AD Org ID 0 (109927070478):
	* when importing ESR-Data, we now accept C_BPartners with AD_Org_ID=0, because besides being a different number, it's not an inconsistency to have a partner with no org
  - 09823 Tax Code Migration (107275491843)
    * making a fix to the work-package processor that is used by the database function "de.metas.async".executeSqlAsync(p_Sql text)
 - 09812 create report for daily packaging material balance (101400050316)
    * minor layouting fixes
 - 09834 adjustment possibility for empties (105285329048)
    * minor layouting fixes

## Instructions

# metasfresh 4.4.3

## Features
 - 09834 adjustment possibility for empties (105285329048)
    * introducing a new doctype to be used for packaging material (empties) adjustments
 - 09839 Customer Individual InOut (109838130709)
    * another alternative shipment document that among other things also lists product which are generally delivered to the customer, even if they are not part of  this particular shipment.
 - 09822 Inter-Org Product Mapping Process (104151535488)
    * allows a user to add and remove product mappings between different organisations
 - 09661 Report "Statistik für monatliche Lagermeldung" - grouping per product and selected attributes (106566269211)
 - 09837 Report Gebinde Übersicht change (103471986337)
 - 09740 ADR revenue report by product categories (101851459609) +it +feature
    * added french translations

## Fixes
 - 09812 create report for daily packaging material balance (101400050316)
    * minor layouting fixes
 - 09281 create report for packaging material balance (106483495857)
    * grouping/summing fixes

# metasfresh 4.3.2

## Features

 - 09826 Take out foot note in purchase order Jasper
    * it's now configurable via property file
 - 09827 Do not show ADR Keine/Leer on HU material receipt label
 - 09828 Salesgroups report add a filter for domestic/foreign country (101738461475)
 - 09832 Allow the printing client to retry on error (106406507107)
 - 09814 Send valid json to the printing client, also if there is an exception in the ESB (103239718792)
 - 09823 Tax Code Migration (107275491843)
    * implemented the database function "de.metas.async".executeSqlAsync(p_Sql text) as a tool to perform time-consuming SQL-migrations in the background
 - 09812 create report for daily packaging material balance (101400050316)
 - 09776 EDI - Receiver without ORDERS (100584995833)
    * we now can specify a default POReference value for orders that is autumatically set by the system, unless there already was another POReference set by a users of from an importnert order
	* for a DESADV lines with unknown CUperTU, we can now set a default-value such a "1" per C_BPartner.

## Fixes

 - 09829 ESB sends HTTP code 204 to the printing client (108552946334)
 - 09281 create report for packaging material balance (106483495857)
    * the former version also showed for a partner also packgings that were not on a particular partner's contract
 - 09820 Header notification bar not shown in main menu (100919535984)
 - 09831 Exception in the Initial Setup Wizard (108054071490)
 - In process parameter panel, display VImage preview, but bound to a maximum size
 - ClientSetup: company name changes were not persisted

## Instructions

 - to use the latest printing ESB bundle (tasks 09829 and 09814), one needs to install the jackson-jaxrs-json provider in the OSGI container (smx):
 ```
bundle:install mvn:com.fasterxml.jackson.jaxrs/jackson-jaxrs-base/2.6.3
bundle:install mvn:com.fasterxml.jackson.jaxrs/jackson-jaxrs-json-provider/2.6.3
 ```

# metasfresh 4.2.1

 - 09281 create report for packaging material balance (106483495857) +it +feature
 - 09740 ADR revenue report by product categories (101851459609) +it +feature
 - 09819 Eliminate duplicated TaxBL and throw an informative exception if... (103899585460) +it +feature
    * removed a code redundancy and source of FUD
    * made it easier to understand why no C_Tax was found for a particular order line
 - 09799 Confusion around Picking Process (108712103881) +it +fix
    * fixing a problem that the picked quantity was sometimes not updated properly in the shipment schedule
 - 09700 Counter orders with mapped products (100691234288) +it +fix
    * fixing a problem with inconsistencies between the newly copied counter order line's old PLV and its new order's PL
 - 09811 EDI creating adjustment charge fails with NullPointerException (100746048824) +it +fix
 - 09797 Confirm completion of order with enter after popup (104892862993) +it +fix
 - 09802 Docaction after Prepared shall be Completed (100319295346) +it +fix
    * when createing purchase orders from sales orders, the drafted purchase orders' doc action is now "complete"
 - 09794 Metasfresh performance improvements (109453118224) +it +feature
    * speedup for the check whether the client still has a DB connection
	* not always loading each field's context menu items without them being needed
 - 09800 Scrolling in Picking terminal first window looks weird (106972300023) +it +fix
 - 09502 quality inspection (100925494419) +it +fix
    * recompute invoice candidates, also on PP_Order unclose
	* when computing the already-paid amount in the final settlement, don't take into account ordinary invoiced like packaging releated invoices
 - 09809 Report direct costing Year Title wrong (103628559355) +it +fix
 - 09803 Revenue report fix (109269170462) +it +fix
 - 09281 create report for packaging material balance (106483495857) +it +feature
 - 09779 Report C Activity ID swap changes (101962781663) +it +feature
 - 09783 Improve Salesgroups - migration and report (105684868719) +it +feature
 - 09801 Customer Individual Shipment change (104284980744) +it +feature
    * minor change to the alternative shipment jasper
 - 09804 Account-Information: don't show and sum Budget (106521617847) +it +fix
 - 09677 extending the BPartner changes report (107837562286) +it +feature
 - 09502_Support quality based invoicing +it +fix
    * directly refresh/recreate existing invoice candidates when a PP_Order is unclosed; don't wait for it to be closed again
 - 09700 Counter orders with mapped products (100691234288) +it +feature
    * allow counter orders (sames order in one org => purchase order in another) with org-internal products that are mapped against each other
 - 09773 Signature fix in shipment jasper (100363111538) +it +fix
 - 09782 remove note from purchase invoice (109638032503) +it +fix
 - 09788 Show isInfiniteCapacity in Pricelist (106197421720) +it +fix
 - 09785 F4-save does not work anymore in included invoice line tab +it +fix
 - 09780 Sorting of List Reference for PriceListVersion (105389853564) +it +feature
 - 09777 German Translations for Salesgroup (106405148729) +it +fix
    * small changes for Salesgroup Translations
 - 09625 Costing short report incl Budget (105806249331) +it +fix
 - 09710 Report regarding effective prices (107746499502) +uat +fix
    * layout/display fix rergarding the report's page number
 - 09766 VAT codes (107418136945) +uat +feature
    * allow defining different VAT codes for sales and purchase, and matching them with each other
 - 09739 gain and loss during bank transfers in foreign currencies (108136874441) +uat +feature
    * introducing default conversion type that can be specified to be active at a given time
	* currency gain and loss from bank account transfers are computed by comparing default conversion type with the default conversion rate
 - 09110 Make activity mandatory in accounting documents and allow the user to select one on demand (105477200774) +uat +feature
 - 09775 Import GL Journal Number Format Exception (104021981594): +it +feature
    * when importing values into a non-text filed that can't be parsed as number, date etc, then don't fail the whole import
 - minor, unrelated fix: when retrieving dunning levels, order them by +it +fix
    *"DaysAfterDue" to make sure they are dealt with in chronological order.
    *Actually, the order might not matter, but a counterintuitive ordering causes FUD.
 - 09771 Dunning docs mail (102929053917) +it +fix +feature
    * small changes around the dunning jasper

# it-S16_05-20160202
 - fixed the default location of the client properties file from <user.home>/.metas-fresh to <user.home>/.metasfresh +it +fix
 - 09741 Problems with HU labels for split HUs (104680331233) +uat +fix
 - 09765 Process to manually re-open C_PAySelection records that were already prepared (108508031142) +uat +feature
 - 09745 alternative jasper shipment document without ADR but explicit GMAA-values (107947997555) +uat +feature
 - 09726 Deep-copy support for AD Roles (106651676304) +uat +feature
    * we now also copy user-role assignements to the target role
 - 09625 Costing short report incl Budget (105806249331) +uat +feature
 - 09767 DBMoreThenOneRecordsFoundException when retrieving from picking slot queue (105944016827) +uat +fix
 - 09710 Report regarding effective prices (107746499502)
 - 09704 Migration ADempiere to metasfresh (100169279454) +it +feature
    * making hardcoded endcustomer-feature configurable for all metasfresh users
 - 09752 system creates two printing queue items for gernic reports (107420055849) +it +fix
 - 09764 servicemix update (102943200308): the esb bundles now use
