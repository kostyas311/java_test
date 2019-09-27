package ru.grandsmeta.document.impl.xml;

import ru.grandsmeta.document.Document;
import ru.grandsmeta.document.DocumentType;

public class XmlFactorsList extends XmlContainer {

	public XmlFactorsList(Document document) {
		super(document, Consts.T_FACTORLIST);
	}

	@Override
	protected XmlItem newItem(String xmlTag) {
		switch (xmlTag){
		case Consts.T_FACTOR:
			return new XmlFactor(getDocument());
		}
		return null;
	}

	@Override
	protected boolean needToSave() {
		return count() > 0 && getDocument().getDocumentType() == DocumentType.dtBaseData;
	}

}
