package ru.grandsmeta.document.impl.xml;

import java.util.HashSet;
import java.util.Set;

import ru.grandsmeta.document.Document;
import ru.grandsmeta.document.DocumentType;
import ru.grandsmeta.document.Index;

public class XmlIndex extends XmlItem implements Index {

	public XmlIndex(Document document) {
		super(document, Consts.T_INDEX);
	}


	@Override
	public double getWorkerSalaryIndex() {
		return Double.parseDouble(getAttrib(Consts.A_INDEX_OZ));
	}

	@Override
	public double getDirectCostIndex() {
		return Double.parseDouble(getAttrib(Consts.A_INDEX_SMR));
	}

	@Override
	public double getMachineCostIndex() {
		return Double.parseDouble(getAttrib(Consts.A_INDEX_EM));
	}

	@Override
	public double getMaterialCostIndex() {
		return Double.parseDouble(getAttrib(Consts.A_INDEX_MT));
	}

	@Override
	public double getMechanicSalaryIndex() {
		return Double.parseDouble(getAttrib(Consts.A_INDEX_ZM));
	}

	@Override
	public void setWorkerSalaryIndex(double value) {
		setAttrib(Consts.A_INDEX_OZ, Double.toString(value));
	}

	@Override
	public void setDirectoryCostIndex(double value) {
		setAttrib(Consts.A_INDEX_SMR, Double.toString(value));
	}

	@Override
	public void setMachineCostIndex(double value) {
		setAttrib(Consts.A_INDEX_EM, Double.toString(value));
	}

	@Override
	public void setMaterialCostIndex(double value) {
		setAttrib(Consts.A_INDEX_MT, Double.toString(value));
	}

	@Override
	public boolean isCostSeparated() {
		return getAttrib(Consts.A_INDEX_OPTIONS).equals(Consts.AV_INDEX_SEPAREM);
	}

	@Override
	public void setCostSeparated(boolean value) {
		if (value) 
			setAttrib(Consts.A_INDEX_OPTIONS, Consts.AV_INDEX_SEPAREM); 
		else
			setAttrib(Consts.A_INDEX_OPTIONS, null);
	}

	@Override
	protected Set<String> getAttribs() {
		Set<String> attribs = new HashSet<String>();
		attribs.add(Consts.A_INDEX_CODE);
		attribs.add(Consts.A_INDEX_CAPTION);
		attribs.add(Consts.A_INDEX_EM);
		attribs.add(Consts.A_INDEX_MT);
		attribs.add(Consts.A_INDEX_OZ);
		attribs.add(Consts.A_INDEX_SMR);
		attribs.add(Consts.A_INDEX_ZM);
		attribs.add(Consts.A_INDEX_OPTIONS);
		return attribs;
	}

	@Override
	protected boolean needToSave() {
		return getDocument().getDocumentType() == DocumentType.dtIndex;
	}

	@Override
	protected XmlItem newItem(String xmlTag) {
		return null;
	}

	@Override
	public String getCode() {
		return getAttrib(Consts.A_INDEX_CODE);
	}

	@Override
	public String getCaption() {
		return getAttrib(Consts.A_INDEX_CAPTION);
	}

	@Override
	public void setCode(String code) {
		setAttrib(Consts.A_INDEX_CODE, code);		
	}

	@Override
	public void setCaption(String caption) {
		setAttrib(Consts.A_INDEX_CAPTION, caption);
		
	}

}
