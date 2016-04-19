package com.ibm.rdh.rfc.proxy;

//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Vector;
//
//import com.ibm.pprds.swpims.domain.Announcement;
//import com.ibm.pprds.swpims.domain.AnnouncementGeo;
//import com.ibm.pprds.swpims.domain.GeoCountry;
//import com.ibm.pprds.swpims.domain.PlannedSalesStatus;
//import com.ibm.pprds.swpims.domain.ProcessOptionFeature;
//import com.ibm.pprds.swpims.domain.ProductLifecycleStatus;
//import com.ibm.pprds.swpims.domain.RegistrationFeature;
//import com.ibm.pprds.swpims.domain.RegularEntitlementFeature;
//import com.ibm.pprds.swpims.domain.SWO;
//import com.ibm.pprds.swpims.domain.SupplyFeature;
//import com.ibm.pprds.swpims.domain.Sw300;
//import com.ibm.pprds.swpims.domain.Sw300Characteristic;
//import com.ibm.pprds.swpims.domain.SwFeature;
//import com.ibm.pprds.swpims.domain.UpgradeEntitlementFeature;
//import com.ibm.pprds.swpims.rfc.ReturnDataObjectR001;
//
import java.util.Date;
import java.util.Vector;

import com.ibm.rdh.chw.entity.CHWAnnouncement;
import com.ibm.rdh.chw.entity.CHWGeoAnn;
import com.ibm.rdh.chw.entity.LifecycleData;
import com.ibm.rdh.chw.entity.PlannedSalesStatus;
import com.ibm.rdh.chw.entity.TypeFeature;
import com.ibm.rdh.chw.entity.TypeFeatureUPGGeo;
import com.ibm.rdh.chw.entity.TypeModel;
import com.ibm.rdh.chw.entity.TypeModelUPGGeo;
import com.ibm.rdh.rfc.BapireturnStructure;

/**
 * @author Will
 */
public abstract class RfcProxy {
	private RfcFactory _rfcFactory;

	protected RfcFactory getFactory() {
		return getRfcFactory();
	}

	protected RfcFactory getRfcFactory() {
		return _rfcFactory;
	}

	/*
	 * rjc - this class will instantiate the respective RFC and then NOT execute
	 * it. in some cases, bogus data will be created to test the promote.
	 */

	public abstract void r100(CHWAnnouncement chwA, TypeModel typeModel,
			CHWGeoAnn chwAg, String newFlag, TypeModelUPGGeo tmUPGObj,
			String FromToType, String pimsIdentity) throws Exception;

	public abstract void r101(CHWAnnouncement chwA, TypeModel typeModel,
			CHWGeoAnn chwAg, String newFlag, String loadingGrp,
			TypeModelUPGGeo tmUPGObj, String FromToType, String pimsIdentity,
			String plantValue) throws Exception;

	public abstract void r102(CHWAnnouncement chwA, TypeModel typeModel,
			String sapPlant, String newFlag, TypeModelUPGGeo tmUPGObj,
			String FromToType, String pimsIdentity, String flfilcd,
			String salesOrg, Vector taxCntryList) throws Exception;

	public abstract void r103(TypeModel typeModel, String newFlag,
			CHWAnnouncement chwA, TypeModelUPGGeo tmUPGObj, String FromToType,
			String pimsIdentity) throws Exception;

	public abstract void r104(TypeModel typeModel, String newFlag,
			CHWAnnouncement chwA, TypeModelUPGGeo tmUPGObj, String FromToType,
			String pimsIdentity) throws Exception;

	public abstract void r106(TypeModel typeModel, CHWAnnouncement chwA,
			String pimsIdentity) throws Exception;

	public abstract void r107(String type, CHWAnnouncement chwA,
			String pimsIdentity) throws Exception;

	public abstract void r108(TypeModel typeModel, CHWAnnouncement chwA,
			String pimsIdentity) throws Exception;

	public abstract void r109(String type, CHWAnnouncement chwA,
			String pimsIdentity) throws Exception;

	public abstract void r110(TypeModel typeModel, CHWAnnouncement chwA,
			String pimsIdentity) throws Exception;

	public abstract void r111(String type, CHWAnnouncement chwA,
			String pimsIdentity) throws Exception;

	public abstract void r115(CHWAnnouncement chwA, TypeModel typeModel,
			CHWGeoAnn chwAg, String pimsIdentity, String plantValue)
			throws Exception;

	public abstract void r116(CHWAnnouncement chwA, TypeModel typeModel,
			String sapPlant, String loadingGroup, CHWGeoAnn chwAg,
			String storageLocation, String pimsIdentity) throws Exception;

	public abstract void r117(CHWAnnouncement chwA, String typemod, String div,
			String acctAsgnGrp, PlannedSalesStatus ps, boolean bumpCtr,
			String pimsIdentity, String flfil, String salesOrg1,
			String productHierarchy, Vector VectTaxList, String plantValue)
			throws Exception;

	public abstract void r118(TypeModel typeModel, CHWAnnouncement chwA,
			String flfilcd, String warrantyPeriod, boolean remarkable,
			String pimsIdentity) throws Exception;

	public abstract void r119(String typemod, CHWAnnouncement chwA,
			boolean mgCommon, boolean bumpctr, String pimsIdentity)
			throws Exception;

	public abstract void r120(TypeModel typeModel, CHWAnnouncement chwA,
			String pimsIdentity) throws Exception;

	public abstract void r121(TypeModel typeModel, CHWAnnouncement chwA,
			String pimsIdentity) throws Exception;

	public abstract void r123(String type, TypeModelUPGGeo tmUPGObj,
			String newFlag, CHWAnnouncement chwA, String FromToType,
			String pimsIdentity) throws Exception;

	public abstract void r124(Vector tmugV, CHWAnnouncement chwA,
			String pimsIdentity) throws Exception;

	public abstract void r125(String type, CHWAnnouncement chwA,
			String newFlag, String pimsIdentity) throws Exception;

	public abstract void r126(TypeFeature typeFeature, CHWAnnouncement chwA,
			String pimsIdentity) throws Exception;

	public abstract void r127(TypeFeature typeFeature, String featRanges,
			CHWAnnouncement chwA, String pimsIdentity) throws Exception;

	public abstract void r128(TypeFeature typeFeature, String featRanges,
			CHWAnnouncement chwA, String pimsIdentity) throws Exception;

	public abstract void r129(TypeFeature typeFeature, CHWAnnouncement chwA,
			String pimsIdentity) throws Exception;

	public abstract void r130(String type, String featRanges,
			CHWAnnouncement chwA, String pimsIdentity) throws Exception;

	public abstract void r131(String type, String featRanges,
			CHWAnnouncement chwA, String pimsIdentity) throws Exception;

	public abstract void r133(TypeModel typeModel, CHWAnnouncement chwA,
			String pimsIdentity) throws Exception;

	public abstract void r134(TypeFeature typeFeature, CHWAnnouncement chwA,
			String pimsIdentity) throws Exception;

	public abstract void r135(TypeFeature typeFeature, CHWAnnouncement chwA,
			String pimsIdentity) throws Exception;

	public abstract void r144(String annno, String zdmstatus,
			String pimsIdentity) throws Exception;

	public abstract void r150(TypeModel typeModel, CHWAnnouncement chwA,
			String pimsIdentity) throws Exception;

	public abstract void r151(String type, CHWAnnouncement chwA,
			String pimsIdentity) throws Exception;

	public abstract void r152(TypeFeature typeFeature, CHWAnnouncement chwA,
			String pimsIdentity) throws Exception;

	public abstract void r153(TypeFeature typeFeature, CHWAnnouncement chwA,
			String pimsIdentity) throws Exception;

	public abstract void r156(String typemod, String div, CHWAnnouncement chwA,
			String pimsIdentity, boolean seoFlag) throws Exception;

	public abstract void r157(CHWAnnouncement chwA, TypeModelUPGGeo tmUPGObj,
			String FromToType, String pimsIdentity) throws Exception;

	public abstract void r159(CHWAnnouncement chwA, TypeModelUPGGeo tmUPGObj,
			String FromToType, String pimsIdentity) throws Exception;

	public abstract void r160(TypeModel typeModel, CHWAnnouncement chwA,
			String pimsIdentity) throws Exception;

	public abstract void r162(TypeFeatureUPGGeo tfugObj,
			TypeModelUPGGeo tmUPGObj, String newFlag, CHWAnnouncement chwA,
			String FromToType, String pimsIdentity) throws Exception;

	public abstract void r165(CHWAnnouncement chwA, TypeModelUPGGeo tmUPGObj,
			String FromToType, String pimsIdentity) throws Exception;

	public abstract void r166(CHWAnnouncement chwA, TypeModel typeModel,
			CHWGeoAnn chwAg, String storageLocation, String newFlag)
			throws Exception;

	public abstract void r171(String typemod, CHWAnnouncement chwA,
			String pimsIdentity) throws Exception;

	public abstract void r172(TypeModel typeModel, CHWAnnouncement chwA,
			String pimsIdentity) throws Exception;

	public abstract void r175(TypeModel typemodel, TypeModelUPGGeo tmUPGObj,
			CHWAnnouncement chwA, String newFlag, String FromToType,
			String pimsIdentity) throws Exception;

	public abstract void r176(String type, String range, String newFlag,
			CHWAnnouncement chwA, String pimsIdentity) throws Exception;

	public abstract void r177(String type, String range, CHWAnnouncement chwA,
			String pimsIdentity) throws Exception;

	public abstract void r182(TypeModel typeModel, CHWAnnouncement chwA,
			String pimsIdentity) throws Exception;

	public abstract void r183(String annDocNo, String typemod, String sapPlant,
			String pimsIdentity, String profitCenter) throws Exception;

	public abstract void r185(TypeModelUPGGeo typeModel, CHWAnnouncement chwA,
			String pimsIdentity) throws Exception;

	public abstract void r186(TypeFeature typeFeature, CHWAnnouncement chwA,
			String pimsIdentity) throws Exception;

	public abstract void r187(TypeFeature typeFeature, CHWAnnouncement chwA,
			String pimsIdentity) throws Exception;

	public abstract void r188(TypeFeature tfObj, CHWAnnouncement chwA,
			String pimsIdentity) throws Exception;

	public abstract void r189(CHWAnnouncement chwA, TypeModel typeModel,
			String sapPlant, String newFlag, TypeModelUPGGeo tmUPGObj,
			String FromToType, String pimsIdentity) throws Exception;

	public abstract void r197(String material, String varCond,
			String salesStatus, Date validFrom, Date validTo, String user,
			String annDocNo, String check, String pimsIdentity, String salesOrg)
			throws Exception;

	public abstract void r198(String material, String varCond,
			String salesStatus, Date validFrom, Date validTo, String user,
			String annDocNo, String check, String pimsIdentity, String salesOrg)
			throws Exception;

	public abstract void r199(String material, String varCond,
			String salesStatus, Date validTo, String user, String annDocNo,
			String check, String pimsIdentity, String salesOrg)
			throws Exception;

	public abstract LifecycleData r200(String material, String varCond, String annDocNo,
			String check, String pimsIdentity, String salesOrg)
			throws Exception;

	public abstract boolean r207(String type, String model, String plant)
			throws Exception;

	public abstract BapireturnStructure r209(String material) throws Exception;

	public abstract void r261(String material) throws Exception;

	public abstract void r262(CHWAnnouncement chwA, String material,
			String sapPlant, String pimsIdentity, String profitCenter)
			throws Exception;

	// public abstract ReturnDataObjectR001 r001(SWO swo) throws Exception ;
	// public abstract boolean r002(SWO swo, String salesOrg) throws Exception;
	// public abstract Vector r002DataFunction(SWO swo, GeoCountry country, int
	// function) throws Exception;
	// public abstract void r003(SWO swo, GeoCountry country) throws Exception;
	// public abstract void r004(SWO swo, AnnouncementGeo annGeo) throws
	// Exception;
	// public abstract void r005(SWO swo, Announcement ann, String plant) throws
	// Exception;
	// public abstract void r006(SWO swo, GeoCountry country, Announcement ann,
	// PlannedSalesStatus pss) throws Exception ;
	// public abstract void r007(SWO swo, GeoCountry country, String actionCode,
	// PlannedSalesStatus pss) throws Exception;
	// public abstract void r008(SWO swo, Announcement ann) throws Exception;
	// public abstract void r009(SWO swo, Announcement ann) throws Exception;
	// public abstract boolean r010(SWO swo, String classRange ) throws
	// Exception;
	// public abstract void r011(SWO swo, Sw300 sw300) throws Exception;
	// public abstract void r012(SWO swo, Announcement ann, Sw300 sw300 ) throws
	// Exception;
	// public abstract void r012(SWO swo, Announcement ann, Sw300 sw300,
	// Sw300Characteristic swc ) throws Exception;
	// public abstract void r013(SWO swo, Announcement ann, Sw300 sw300 ) throws
	// Exception;
	// public abstract void r013(SWO swo, Announcement ann, Sw300 sw300,
	// Sw300Characteristic swc ) throws Exception;
	// public abstract void r014(SWO swo, Announcement ann, Sw300Characteristic
	// swc ) throws Exception;
	// public abstract void r015(SWO swo, RegularEntitlementFeature feat) throws
	// Exception;
	// public abstract void r016(SWO swo, UpgradeEntitlementFeature uef) throws
	// Exception;
	// public abstract void r017(SWO swo, SupplyFeature sf) throws Exception;
	// public abstract void r018(SWO swo, ProcessOptionFeature pof) throws
	// Exception;
	// public abstract void r019(SWO swo, RegistrationFeature rf) throws
	// Exception;
	// public abstract void r020(SWO swo, Announcement ann, Collection
	// deleteList) throws Exception;
	// public abstract boolean r021(SWO swo, String plant) throws Exception;
	// public abstract Vector r021DataFunction(SWO swo, int function, String
	// plant) throws Exception ;
	// public abstract void r022(SWO swo, String plant ) throws Exception;
	// public abstract void r023(SWO swo, Stpo_api02Table stpoTable, String
	// plant) throws Exception;
	// public abstract void r024(SWO swo, String plant ) throws Exception;
	// public abstract boolean r025(SWO swo, String plant) throws Exception ;
	// public abstract Vector r025DataFunction(SWO swo, int function, String
	// plant) throws Exception ;
	// public abstract void r026(SWO swo, String plant ) throws Exception;
	// public abstract void r027(SWO swo, Stpo_api02Table stpoTable, String
	// plant) throws Exception;
	// public abstract void r028(SWO swo, String plant ) throws Exception;
	// public abstract boolean r029(SWO swo, String plant) throws Exception;
	// public abstract Vector r029DataFunction(SWO swo, int function, String
	// plant) throws Exception ;
	// public abstract void r030( SWO swo, String plant ) throws Exception;
	// public abstract void r031(SWO swo, Stpo_api02Table stpoTable, String
	// plant) throws Exception;
	// public abstract void r032(SWO swo, String plant ) throws Exception;
	// public abstract void r033(SWO swo, SwFeature feat) throws Exception;
	// public abstract Vector r033DataFunction(SWO swo, String classNum, int
	// function) throws Exception;
	// public abstract boolean r034(SWO swo, Sw300Characteristic swc, String
	// classRange ) throws Exception;
	// public abstract boolean r034(SWO swo, String swc, String classRange )
	// throws Exception;
	//
	// public abstract boolean r035(SWO swo, String plant ) throws Exception;
	// public abstract void r036(SWO swo, String plant ) throws Exception;
	// public abstract void r037(SWO swo ) throws Exception;
	// public abstract void r038(SWO swo ) throws Exception;
	// public abstract void r039(SWO swo, Announcement ann ) throws Exception;
	// public abstract void r040(SWO swo, Sw300 sw300) throws Exception;
	//
	// public abstract boolean r041(SWO swo, String plant) throws Exception ;
	// public abstract Vector r041DataFunction(SWO swo, int function, String
	// plant) throws Exception ;
	// public abstract void r042(SWO swo, String plant) throws Exception ;
	// public abstract void r043(SWO swo, Stpo_api02Table stpoTable, String
	// plant) throws Exception;
	// public abstract void r044(SWO swo, String plant) throws Exception;
	// public abstract void r045(String swoID, String scheuduleID) throws
	// Exception;
	// public abstract void r046(SWO swo, Announcement ann, String plant) throws
	// Exception;
	//
	// public abstract boolean r047(SWO swo, String plant) throws Exception ;
	// public abstract Vector r047DataFunction(SWO swo, int function, String
	// plant) throws Exception ;
	// public abstract void r048(SWO swo, String plant) throws Exception ;
	// public abstract void r049(SWO swo, Stpo_api02Table stpoTable, String
	// plant) throws Exception;
	// public abstract void r050(SWO swo, String plant) throws Exception;
	// public abstract void r051(String typeModel) throws Exception;
	// public abstract boolean r052(SWO swo, ProductLifecycleStatus pls) throws
	// Exception;
	// public abstract Vector r052DataFunction(SWO swo, ProductLifecycleStatus
	// pls, int function) throws Exception;
	// public abstract boolean r053(SWO swo, ProductLifecycleStatus pls) throws
	// Exception;
	// public abstract boolean r054(SWO swo, ProductLifecycleStatus pls) throws
	// Exception;
	// public abstract boolean r055(SWO swo, ProductLifecycleStatus pls) throws
	// Exception;
	// public abstract void r056(SWO swo, Vector ipCollection) throws Exception;
	// public abstract void r057(SWO swo, Announcement ann, String plant) throws
	// Exception;
	// public abstract void r058(SWO swo, Announcement ann) throws Exception;
	// public abstract void r059(SWO swo, GeoProfile profile, Announcement ann)
	// throws Exception;
	// public abstract ArrayList r060(SWO swo, Announcement ann, Collection
	// plants) throws Exception;
	// public abstract void r061(SWO swo, Announcement ann, String plant) throws
	// Exception;

	// public abstract Connection getConnection();

	protected void setRfcFactory(RfcFactory factory) {
		_rfcFactory = factory;
	}

}