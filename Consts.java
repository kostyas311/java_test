package ru.grandsmeta.document.impl.xml;

import ru.grandsmeta.document.*;

//T - XML node tag name
//A - attribute name
//AV - attribute value
public final class Consts {
	public static final String T_DOCUMENT                     = "Document";
	public static final String T_CHAPTERS                     = "Chapters";
	public static final String T_INDEXES                      = "Indexes";
	public static final String T_FOLDER                       = "Folder";
	public static final String T_MATERIALS                    = "Materials";
	public static final String T_WORKERS                      = "Workers";
	public static final String T_MACHINES                     = "Machines";
	public static final String T_MECHANICS                    = "Mechanics";
	public static final String T_ZONES                        = "Zones";
	public static final String T_ZONE                         = "Zone";
	public static final String T_ROW                          = "Row";
	public static final String T_CHAPTER                      = "Chapter";
	public static final String T_RESOURCEBULLETIN             = "ResourceBulletin";
	public static final String T_HISTORY                      = "History";
	public static final String T_MEASUREUNITS                 = "MeasureUnits";
	public static final String T_ELEM                         = "Elem";
	public static final String T_INDEX                        = "Index";
	public static final String T_INDEXESADDONS                = "IndexesAddOns";
	public static final String T_DETAIL                       = "Detail";
	public static final String T_FACTOR                       = "Factor";
	public static final String T_RELATIVEFACTOR               = "RelativeFactor";
	public static final String T_MEASUREUNIT                  = "MeasureUnit";
	public static final String T_WORKERLIST                   = "WorkerList";
	public static final String T_MECHANICSLIST                = "MachinistList";
	public static final String T_MACHINESLIST                 = "MachineList";
	public static final String T_MATERIALSLIST                = "MaterialList";
	public static final String T_WORKSLIST                    = "WorksList";
	public static final String T_FACTORLIST                   = "FactorList";
	public static final String T_NOTELIST                     = "NoteList";
	public static final String T_RELATIVEFACTORS              = "RelativeFactors";
	public static final String T_TZ                  	      = "TZ";
	public static final String T_TZM                    	  = "TZM";
	public static final String T_PZ                           = "PZ";
	public static final String T_OZ                   	      = "OZ";
	public static final String T_EM                     	  = "EM";
	public static final String T_ZM                      	  = "ZM";
	public static final String T_MT                           = "MT";
	public static final String T_PRICE              	      = "Price";
	public static final String T_PRICEA                 	  = "PriceA";
	public static final String T_PRICEB               	      = "PriceB";
	public static final String T_MASS                   	  = "Mass";
	public static final String T_PRICEBT             	      = "PriceBT";
	public static final String T_WSP                    	  = "WSP";
	public static final String T_OUTLAY                       = "Outlay";
	public static final String T_COUNT                 	      = "Count";
	public static final String T_RESOURCE                     = "Resource";
	public static final String T_HISTORYITEM                  = "HistoryItem";
	public static final String T_FACTORSSUMMARY               = "FactorsSummary";

	public static final String AV_DOCUMENT_TYPE_CARGO         = "Cargo";
	public static final String AV_DOCUMENT_TYPE_MATERIALS     = "Materials";
	public static final String AV_DOCUMENT_TYPE_MACHINES      = "Machines";
	public static final String AV_DOCUMENT_TYPE_WORKERS       = "WorkerScale"; 
	public static final String AV_DOCUMENT_TYPE_ROWS          = "Rows";
	public static final String AV_DOCUMENT_TYPE_ESN           = "ESNs";
	public static final String AV_DOCUMENT_TYPE_ER            = "ERs";
	public static final String AV_DOCUMENT_TYPE_PROJECT       = "Project";
	public static final String AV_DOCUMENT_DOCUMENTTYPE_BASE  = "{F8DBBC3C-E193-4E5A-B899-950F89F2C986}";
	public static final String AV_DOCUMENT_DOCUMENTTYPE_INDEX = "{2B0470FD-477C-4359-9F34-EEBE36B7D347}";
	public static final String AV_DOCUMENT_DOCUMENTTYPE_PRICE = "{2B0470FD-477C-4359-9F34-EEBE36B7D348}";
	public static final String AV_CHAPTER_YES                 = "Yes";
	public static final String AV_CHAPTER_CHAPTER              = "Chapter";
	public static final String AV_CHAPTER_TABLE                = "Table";
	public static final String AV_CHAPTER_TITLE                = "SharedTitle";
	
	public static final String A_CHAPTER_NUMBER               = "Number";
	public static final String A_CHAPTER_CAPTION              = "Caption";
	public static final String A_CHAPTER_GUID                 = "GUID";
	public static final String A_CHAPTER_TYPE                 = "Type";
	public static final String A_CHAPTER_NUMBERFORMATIVE      = "NumberFormative";
	public static final String A_CHAPTER_TITLEFORMATIVE       = "TitleFormative";
	
	public static final String A_ZONE_CODE                    = A_CHAPTER_NUMBER;
	public static final String A_ZONE_CAPTION                 = A_CHAPTER_CAPTION;
	public static final String A_DOCUMENT_DOCUMENTTYPE        = "DocumentType";
	public static final String A_DOCUMENT_NUMBER              = A_ZONE_CODE;
	public static final String A_DOCUMENT_TITLE               = "Title";
	public static final String A_DOCUMENT_ID                  = "ID";
	public static final String A_DOCUMENT_YEAR                = "Year";
	public static final String A_DOCUMENT_TYPENAME            = "TypeName";
	public static final String A_DOCUMENT_TYPE                = A_CHAPTER_TYPE;
	public static final String A_DOCUMENT_GUID                = A_CHAPTER_GUID;
	public static final String A_DOCUMENT_FLAGS               = "Flags";
	public static final String A_DOCUMENT_AREAOFAPP           = "AreaOfApp";
	public static final String A_DOCUMENT_COMMENT             = "Comment";	
	public static final String A_VALUE                        = "Value";
	public static final String A_ROW_NUMBER                   = A_DOCUMENT_NUMBER;
	public static final String A_ROW_CAPTION                  = A_CHAPTER_CAPTION;
	public static final String A_ROW_MEASURE                  = "Units";
	public static final String A_ROW_ID                       = A_DOCUMENT_ID;
	public static final String A_ROW_COMMENT                  = A_DOCUMENT_COMMENT;
	public static final String A_ROW_CARGOCLASS               = "CarGoClass";
	public static final String A_ROW_WORKCODE                 = "WorkCode";
	public static final String A_ROW_OKP                      = "OKP";
	public static final String A_ROW_WORKCLASS                = "WorkClass";
	public static final String A_OUTLAY_OPTIONS               = "Options";
	public static final String AV_OUTLAY_OPTION_NOTCOUNT      = "NotCount";
	public static final String AV_OUTLAY_OPTION_PROJECT       = "Project";
	public static final String AV_OUTLAY_OPTION_RETURN        = "Return";
	
	public static final String AV_RESOURCE_TYPE_MATERIAL      = "Material";
	public static final String AV_RESOURCE_TYPE_WORKER        = "Worker";
	public static final String AV_RESOURCE_TYPE_MACHINIST     = "Machinist";
	public static final String AV_RESOURCE_TYPE_MACHINE       = "Machine";
	public static final String A_RESOURCE_TYPE                = "Kind";
	public static final String A_DETAIL_DETAILTYPE            = "DetailType";
	public static final String A_DETAIL_CAPTION               =  A_ROW_CAPTION;
	public static final String A_DETAIL_ID                    =  A_ROW_ID;
	public static final String A_DETAIL_FLAGS                 =  A_DOCUMENT_FLAGS;
	public static final String A_DETAIL_PZ                    = T_PZ;
	public static final String A_DETAIL_OZ                    = T_OZ;
	public static final String A_DETAIL_EM                    = T_EM;
	public static final String A_DETAIL_ZM                    = T_ZM;
	public static final String A_DETAIL_MT                    = T_MT;
	public static final String A_DETAIL_NUMBER                = A_ROW_NUMBER;
	public static final String A_DETAIL_PROJECTDOCK           = "ProjectDocK";
	public static final String A_DETAIL_WORKDOCK              = "WorkDocK";
	public static final String A_DETAIL_WORKPROJECTK          = "WorkProjectK";
	public static final String A_DETAIL_CODE                  = "Code";
	public static final String A_INDEX_CODE                   = A_DETAIL_CODE;
	public static final String A_INDEX_CAPTION                = A_ROW_CAPTION;
	public static final String A_INDEX_SMR                    = "SMR";
	public static final String A_INDEX_OZ                     = "OZ";
	public static final String A_INDEX_EM                     = "EM";
	public static final String A_INDEX_ZM                     = "ZM";
	public static final String A_INDEX_MT                     = "MT";
	public static final String A_INDEX_OPTIONS                = "Options";
	public static final String AV_INDEX_SEPAREM               = "SeparEM";
	public static final String A_PRICE_CODE                   = A_INDEX_CODE;
	public static final String A_PRICE_CAPTION                = A_INDEX_CAPTION;
	public static final String A_PRICE_MEASURE                = A_ROW_MEASURE;
	public static final String A_PRICE_PRICECE                = "PriceCE";
	public static final String A_PRICE_PRICECT                = "PriceCT";
	public static final String A_PRICE_PRICEBE                = "PriceBE";
	public static final String A_PRICE_PRICEBT                = "PriceBT";
	public static final String A_PRICE_PRICECURRCOMMENT       = "PriceCurrComment";
	public static final String A_PRICE_PRICEBASECOMMENT       = "PriceBaseComment";
	public static final String A_PRICE_COMMENT                = A_ROW_COMMENT;
	public static final String A_PRICE_MASS                   = T_MASS;
	public static final String A_PRICE_CARGO                  = AV_DOCUMENT_TYPE_CARGO;
	public static final String A_PRICE_WORKERCLASS            = A_ROW_WORKCLASS;
	public static final String A_PRICE_OKP                    = A_ROW_OKP;
	
	public static String getXmlName(BaseDataType type) {
		switch (type) {
		case bdtCargo:
			return Consts.AV_DOCUMENT_TYPE_CARGO;

		case bdtERs:
			return Consts.AV_DOCUMENT_TYPE_ER;

		case bdtESNs:
			return Consts.AV_DOCUMENT_TYPE_ESN;

		case bdtMachine:
			return Consts.AV_DOCUMENT_TYPE_MACHINES;

		case bdtMaterial:
			return Consts.AV_DOCUMENT_TYPE_MATERIALS;

		case bdtProject:
			return Consts.AV_DOCUMENT_TYPE_PROJECT;

		case bdtRows:
			return Consts.AV_DOCUMENT_TYPE_ROWS;

		case bdtWorkerScale:
			return Consts.AV_DOCUMENT_TYPE_WORKERS;

		default:
			return null;
		}
	}

	public static String getXmlName(ChapterType type) {
		switch (type) {
		case ctChapter:
			return Consts.AV_CHAPTER_CHAPTER;

		case ctSharedTitle:
			return Consts.AV_CHAPTER_TITLE;

		case ctTable:
			return Consts.AV_CHAPTER_TABLE;

		default:
			return null;
		}
	}
	
	public static String getXmlName(OutlayOption option){
		switch (option){
		case ooNotCount:
			return Consts.AV_OUTLAY_OPTION_NOTCOUNT;
			
		case ooProject:
			return Consts.AV_OUTLAY_OPTION_PROJECT;
			
		case ooReturn:
			return Consts.AV_OUTLAY_OPTION_RETURN;
			
		default:
			return null;
		}
	}

	public static String getXmlName(DocumentType type) {
		switch (type) {
		case dtBaseData:
			return Consts.AV_DOCUMENT_DOCUMENTTYPE_BASE;
			
		case dtIndex:
			return Consts.AV_DOCUMENT_DOCUMENTTYPE_INDEX;
			
		case dtPrice:
			return Consts.AV_DOCUMENT_DOCUMENTTYPE_PRICE;

		default:
			return null;
		}
	}

	public static String getXmlName(CostType type) {
		switch (type){
		case cstCount:
			return Consts.T_COUNT;
			
		case cstEM:
			return Consts.T_EM;
			
		case cstMass:
			return Consts.T_MASS;
			
		case cstMT:
			return Consts.T_MT;
			
		case cstOZ:
			return Consts.T_OZ;
			
		case cstPrice:
			return Consts.T_PRICE;
			
		case cstPriceA:
			return Consts.T_PRICEA;
			
		case cstPriceB:
			return Consts.T_PRICEB;
			
		case cstPriceBT:
			return Consts.T_PRICEBT;
			
		case cstPZ:
			return Consts.T_PZ;
			
		case cstTZ:
			return Consts.T_TZ;
			
		case cstTZM:
			return Consts.T_TZM;
			
		case cstWSP:
			return Consts.T_WSP;
			
		case cstZM:
			return Consts.T_ZM;
			
		default:
			return null;
		}
	}

	public static String getXmlName(ResourceType type) {
		switch (type){
		case rtMachine:
			return Consts.AV_RESOURCE_TYPE_MACHINE;
			
		case rtMaterial:
			return Consts.AV_RESOURCE_TYPE_MATERIAL;
			
		case rtWorker:
			return Consts.AV_RESOURCE_TYPE_WORKER;
			
		case rtMechanic:
			return Consts.AV_RESOURCE_TYPE_MACHINIST;
			
		default:
			return null;
		}
	}
}
