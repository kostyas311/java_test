package ru.grandsmeta.document.impl.xml;

import ru.grandsmeta.document.Document;
import ru.grandsmeta.document.DocumentType;

public class XmlWorksList extends XmlContainer {

	public XmlWorksList(Document document) {
		super(document, Consts.T_WORKSLIST);
	}

	@Override
	protected XmlItem newItem(String xmlTag) {
		switch(xmlTag){
		case Consts.T_DETAIL:
			return new XmlDetail(getDocument());
		default:
			return null;
		}
	}

	@Override
	protected boolean needToSave() {
		return (count() > 0) && getDocument().getDocumentType() == DocumentType.dtBaseData;
	}

}
