package ru.grandsmeta.document.impl.xml;

import java.util.HashSet;
import java.util.Set;

import ru.grandsmeta.document.Chapter;
import ru.grandsmeta.document.ChapterType;
import ru.grandsmeta.document.Document;
import ru.grandsmeta.document.Item;
import ru.grandsmeta.document.Row;

public class XmlChapter extends XmlItem implements Chapter {

	public XmlChapter(Document document) {
		super(document, Consts.T_CHAPTER);
	}

	@Override
	public String getCode() {
		return getAttrib(Consts.A_CHAPTER_NUMBER);
	}

	@Override
	public String getCaption() {
		return getAttrib(Consts.A_CHAPTER_CAPTION);
	}

	@Override
	public void setCode(String code) {
		setAttrib(Consts.A_CHAPTER_NUMBER, code);
	}

	@Override
	public void setCaption(String caption) {
		setAttrib(Consts.A_CHAPTER_CAPTION, caption);
	}

	@Override
	public String getNumber(boolean includeDocTypeName, boolean includeDocNumber) {
		String number = getCode();
		
		Item parent = getParent();
		while (parent != null){
			if (parent instanceof Chapter && ((Chapter) parent).isNumberFormative())
				number = (((Chapter)parent).getCode()) + "-" + number;
			parent = parent.getParent();
		}
		
		if (includeDocNumber)
			number = getDocument().getNumber() + number;
		
		if (includeDocTypeName)
			number = getDocument().getTypeName() + number;
		
		return number;
	}

	@Override
	public String getGUID() {
		return getAttrib(Consts.A_CHAPTER_GUID);
	}

	@Override
	public boolean isTitleFormative() {
		String value = getAttrib(Consts.A_CHAPTER_TITLEFORMATIVE);
		return  (value != null && value.equals(Consts.AV_CHAPTER_YES) ? true : false);
	}

	@Override
	public boolean isNumberFormative() {
		String value = getAttrib(Consts.A_CHAPTER_NUMBERFORMATIVE);
		return  (value != null && value.equals(Consts.AV_CHAPTER_YES) ? true : false);
	}

	@Override
	public ChapterType getType() {
		switch (getAttrib(Consts.A_CHAPTER_TYPE)){
			case Consts.AV_CHAPTER_CHAPTER:
				return ChapterType.ctChapter;
				
			case Consts.AV_CHAPTER_TABLE:
				return ChapterType.ctTable;
				
			case Consts.AV_CHAPTER_TITLE:
				return ChapterType.ctSharedTitle;
				
			default:
				return null;
		}
	}

	@Override
	public void setTitleFormative(boolean value) {
		String attrib = (value == true) ? Consts.AV_CHAPTER_YES : null;
		setAttrib(Consts.A_CHAPTER_TITLEFORMATIVE, attrib);
	}

	@Override
	public void setNumberFormative(boolean value) {
		String attrib = (value == true) ? Consts.AV_CHAPTER_YES : null;		
		setAttrib(Consts.A_CHAPTER_NUMBERFORMATIVE, attrib);
	}

	@Override
	public void setType(ChapterType value) {
		setAttrib(Consts.A_CHAPTER_TYPE, Consts.getXmlName(value));
	}

	@Override
	protected Set<String> getAttribs() {
		
		Set<String> attribs = new HashSet<>();
		attribs.add(Consts.A_CHAPTER_NUMBER);
		attribs.add(Consts.A_CHAPTER_CAPTION);
		attribs.add(Consts.A_CHAPTER_NUMBERFORMATIVE);
		attribs.add(Consts.A_CHAPTER_TITLEFORMATIVE);
		attribs.add(Consts.A_CHAPTER_TYPE);
		attribs.add(Consts.A_CHAPTER_GUID);

		return attribs;
	}

	@Override
	protected XmlItem newItem(String xmlTag) {
		switch (xmlTag){
			case Consts.T_ROW:
				return new XmlRow(getDocument());
			case Consts.T_CHAPTER:
				return new XmlChapter(getDocument());
			default:
				return null;
		}
	}

	@Override
	protected boolean needToSave() {
		return (getAll((item)->item instanceof Row, true).size() > 0) ? true : false;
	}

}
