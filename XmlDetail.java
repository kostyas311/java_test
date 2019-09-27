package ru.grandsmeta.document.impl.xml;

import java.util.HashSet;
import java.util.Set;

import ru.grandsmeta.document.Detail;
import ru.grandsmeta.document.Document;
import ru.grandsmeta.document.DocumentType;

public class XmlDetail extends XmlItem implements Detail {

	public XmlDetail(Document document) {
		this(document, Consts.T_DETAIL);
	}

	public XmlDetail(Document document, String xmlTag) {
		super(document, xmlTag);
	}

	@Override
	public String getCode() {
		return getAttrib(Consts.A_DETAIL_CODE);
	}

	@Override
	public String getCaption() {
		return getAttrib(Consts.A_DETAIL_CAPTION);
	}

	@Override
	public void setCode(String code) {
		setAttrib(Consts.A_DETAIL_CODE, code);
	}

	@Override
	public void setCaption(String caption) {
		setAttrib(Consts.A_DETAIL_CAPTION, caption);
	}

	@Override
	public String getNumber() {
		return getAttrib(Consts.A_DETAIL_NUMBER);
	}

	@Override
	public int getDetailType() {
		return Integer.parseInt(getAttrib(Consts.A_DETAIL_DETAILTYPE));
	}

	@Override
	public int getID() {
		return Integer.parseInt(getAttrib(Consts.A_DETAIL_ID));
	}

	@Override
	public int getFlags() {
		return Integer.parseInt(getAttrib(Consts.A_DETAIL_FLAGS));
	}

	@Override
	public double getTotalCostIndex() {
		return Double.parseDouble(getAttrib(Consts.A_DETAIL_PZ).replace(",", "."));
	}

	@Override
	public double getWorkerSalaryIndex() {
		return Double.parseDouble(getAttrib(Consts.A_DETAIL_OZ).replace(",", "."));
	}

	@Override
	public double getMachineCostIndex() {
		return Double.parseDouble(getAttrib(Consts.A_DETAIL_EM).replace("," , "."));
	}

	@Override
	public double getMechanicSalaryIndex() {
		return Double.parseDouble(getAttrib(Consts.A_DETAIL_ZM).replace(",", "."));
	}

	@Override
	public double getMaterialCostIndex() {
		return Double.parseDouble(getAttrib(Consts.A_DETAIL_MT).replace(",", "."));
	}

	@Override
	public double getProjectDocIndex() {
		return Double.parseDouble(getAttrib(Consts.A_DETAIL_PROJECTDOCK).replace(",", "."));
	}

	@Override
	public double getWorkDocIndex() {
		return Double.parseDouble(getAttrib(Consts.A_DETAIL_WORKDOCK).replace(",", "."));
	}

	@Override
	public double getWorkProjectIndex() {
		return Double.parseDouble(getAttrib(Consts.A_DETAIL_WORKPROJECTK).replace(",", "."));
	}

	@Override
	public void setNumber(String value) {
		setAttrib(Consts.A_DETAIL_NUMBER, value);
	}

	@Override
	public void setDetailType(int value) {
		setAttrib(Consts.A_DETAIL_DETAILTYPE, Integer.toString(value));
	}

	@Override
	public void setID(int value) {
		setAttrib(Consts.A_DETAIL_ID, Integer.toString(value));
	}

	@Override
	public void setFlags(int value) {
		setAttrib(Consts.A_DETAIL_FLAGS, Integer.toString(value));
	}

	@Override
	public void setTotalCostIndex(double value) {
		setAttrib(Consts.A_DETAIL_PZ, Double.toString(value));
	}

	@Override
	public void setWorkerSalaryIndex(double value) {
		setAttrib(Consts.A_DETAIL_OZ, Double.toString(value));
	}

	@Override
	public void setMachineCostIndex(double value) {
		setAttrib(Consts.A_DETAIL_EM, Double.toString(value));
	}

	@Override
	public void setMechanicSalaryIndex(double value) {
		setAttrib(Consts.A_DETAIL_ZM, Double.toString(value));

	}

	@Override
	public void setMaterialCostIndex(double value) {
		setAttrib(Consts.A_DETAIL_MT, Double.toString(value));

	}

	@Override
	public void setProjectDocIndex(double value) {
		setAttrib(Consts.A_DETAIL_PROJECTDOCK, Double.toString(value));
	}

	@Override
	public void setWorkDocIndex(double value) {
		setAttrib(Consts.A_DETAIL_WORKDOCK, Double.toString(value));
	}

	@Override
	public void setWorkProjectIndex(double value) {
		setAttrib(Consts.A_DETAIL_WORKPROJECTK, Double.toString(value));
	}

	@Override
	protected Set<String> getAttribs() {
		Set<String> attribs = new HashSet<>();
		
		attribs.add(Consts.A_DETAIL_CAPTION);
		attribs.add(Consts.A_DETAIL_CODE);
		attribs.add(Consts.A_DETAIL_DETAILTYPE);
		attribs.add(Consts.A_DETAIL_NUMBER);
		attribs.add(Consts.A_DETAIL_PZ);
		attribs.add(Consts.A_DETAIL_OZ);
		attribs.add(Consts.A_DETAIL_EM);
		attribs.add(Consts.A_DETAIL_MT);
		attribs.add(Consts.A_DETAIL_ZM);
		attribs.add(Consts.A_DETAIL_ID);
		attribs.add(Consts.A_DETAIL_FLAGS);
		attribs.add(Consts.A_DETAIL_PROJECTDOCK);
		attribs.add(Consts.A_DETAIL_WORKDOCK);
		attribs.add(Consts.A_DETAIL_WORKPROJECTK);
		
		return attribs;
	}

	@Override
	protected boolean needToSave() {
		return getDocument().getDocumentType() == DocumentType.dtBaseData;
	}

	@Override
	protected XmlItem newItem(String xmlTag) {
		return null;
	}

}
