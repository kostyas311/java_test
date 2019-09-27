package ru.grandsmeta.document.impl.xml;

import ru.grandsmeta.document.Document;
import ru.grandsmeta.document.DocumentType;

public class XmlChapters extends XmlContainer {

	public XmlChapters(Document document) {
		super(document, Consts.T_CHAPTERS);
	}

	@Override
	protected XmlItem newItem(String xmlTag) {
		switch (xmlTag) {
		case Consts.T_CHAPTER:
			return new XmlChapter(getDocument());
		default:
			return null;
		}
	}

	@Override
	protected boolean needToSave() {
		return getDocument().getDocumentType() == DocumentType.dtBaseData;
	}

}
