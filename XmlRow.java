package ru.grandsmeta.document.impl.xml;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ru.grandsmeta.document.Chapter;
import ru.grandsmeta.document.Cost;
import ru.grandsmeta.document.CostType;
import ru.grandsmeta.document.Document;
import ru.grandsmeta.document.Estimated;
import ru.grandsmeta.document.Item;
import ru.grandsmeta.document.Measured;
import ru.grandsmeta.document.Resource;
import ru.grandsmeta.document.Row;

public final class XmlRow extends XmlItem implements Estimated, Measured, Row {

	private Item machines;
	private Item materials;
	private Item mechanincs;
	private Item workers;
	private Item history;
	private Item works;
	private Item factors;
	private Item relativeFactors;
	private Item notes;
	
	public XmlRow(Document document) {
		super(document, Consts.T_ROW);

		machines = new XmlResourceList(document, Consts.T_MACHINESLIST);
		materials = new XmlResourceList(document, Consts.T_MATERIALSLIST);
		workers = new XmlResourceList(document, Consts.T_WORKERLIST);
		mechanincs = new XmlResourceList(document, Consts.T_MECHANICSLIST);
		works = new XmlWorksList(document);
		factors = new XmlFactorsList(document);
	}

	@Override
	public String getCode() {
		return getAttrib(Consts.A_ROW_NUMBER);
	}

	@Override
	public String getCaption() {

		return getAttrib(Consts.A_ROW_CAPTION);
	}

	@Override
	public void setCode(String code) {
		setAttrib(Consts.A_ROW_NUMBER, code);

	}

	@Override
	public void setCaption(String caption) {
		setAttrib(Consts.A_ROW_CAPTION, caption);

	}

	@Override
	protected Set<String> getAttribs() {
		Set<String> attribs = new HashSet<>();

		attribs.add(Consts.A_ROW_NUMBER);
		attribs.add(Consts.A_ROW_CAPTION);
		attribs.add(Consts.A_ROW_MEASURE);
		attribs.add(Consts.A_ROW_ID);
		attribs.add(Consts.A_ROW_COMMENT);
		attribs.add(Consts.A_ROW_CARGOCLASS);
		attribs.add(Consts.A_ROW_OKP);
		attribs.add(Consts.A_ROW_WORKCODE);
		attribs.add(Consts.A_ROW_WORKCLASS); 

		return attribs;
	}

	@Override
	protected XmlItem newItem(String xmlTag) {
		switch (xmlTag) {
		case Consts.T_PZ:
			return new XmlCost(getDocument(), CostType.cstPZ);

		case Consts.T_OZ:
			return new XmlCost(getDocument(), CostType.cstOZ);

		case Consts.T_EM:
			return new XmlCost(getDocument(), CostType.cstEM);

		case Consts.T_ZM:
			return new XmlCost(getDocument(), CostType.cstZM);

		case Consts.T_MT:
			return new XmlCost(getDocument(), CostType.cstMT);

		case Consts.T_WSP:
			return new XmlCost(getDocument(), CostType.cstWSP);

		case Consts.T_TZ:
			return new XmlCost(getDocument(), CostType.cstTZ);

		case Consts.T_TZM:
			return new XmlCost(getDocument(), CostType.cstTZM);

		case Consts.T_PRICE:
			return new XmlCost(getDocument(), CostType.cstPrice);

		case Consts.T_PRICEBT:
			return new XmlCost(getDocument(), CostType.cstPriceBT);

		case Consts.T_PRICEA:
			return new XmlCost(getDocument(), CostType.cstPriceA);

		case Consts.T_PRICEB:
			return new XmlCost(getDocument(), CostType.cstPriceB);

		case Consts.T_COUNT:
			return new XmlCost(getDocument(), CostType.cstCount);

		case Consts.T_MASS:
			return new XmlCost(getDocument(), CostType.cstMass);

		case Consts.T_WORKERLIST:
			return (XmlItem) getWorkers();

		case Consts.T_MECHANICSLIST:
			return (XmlItem) getMechanics();

		case Consts.T_MACHINESLIST:
			return (XmlItem) getMachines();

		case Consts.T_MATERIALSLIST:
			return (XmlItem) getMaterials();

		case Consts.T_WORKSLIST:
			return (XmlItem) getWorks();

		case Consts.T_FACTORLIST:
			return (XmlItem) getFactors();

		default:
			return null;
		}
	}

	@Override
	public String getMeasure() {
		return getAttrib(Consts.A_ROW_MEASURE);
	}

	@Override
	public void setMeasure(String value) {
		setAttrib(Consts.A_ROW_MEASURE, value);

	}

	@Override
	public Cost getCost(CostType costType) {
		for (int i = 0; i < this.count(); i++) {
			Item item = getItem(i);
			if (item instanceof Cost && ((Cost) item).getType() == costType)
				return (Cost) item;
		}
		
		Cost result = new XmlCost(getDocument(), costType);
		add((Item) result);
		return result;
	}

	@Override
	public String getID() {

		return getAttrib(Consts.A_ROW_ID);
	}

	@Override
	public String getComment() {

		return getAttrib(Consts.A_ROW_COMMENT);
	}

	@Override
	public int getCargoClass() {

		return Integer.parseInt(getAttrib(Consts.A_ROW_CARGOCLASS));
	}

	@Override
	public int getWorkCode() {

		return Integer.parseInt(getAttrib(Consts.A_ROW_WORKCODE));
	}

	@Override
	public String getOKP() {

		return getAttrib(Consts.A_ROW_OKP);
	}

	@Override
	public double getWorkClass() {

		return Double.parseDouble(getAttrib(Consts.A_ROW_WORKCLASS));
	}

	@Override
	public void setID(String value) {

		setAttrib(Consts.A_ROW_ID, value);
	}

	@Override
	public void setComment(String value) {

		setAttrib(Consts.A_ROW_COMMENT, value);
	}

	@Override
	public void setCargoClass(int value) {

		setAttrib(Consts.A_ROW_CARGOCLASS, Integer.toString(value));
	}

	@Override
	public void setWorkCode(int value) {

		setAttrib(Consts.A_ROW_WORKCODE, Integer.toString(value));
	}

	@Override
	public void setOKP(String value) {

		setAttrib(Consts.A_ROW_OKP, value);
	}

	@Override
	public void setWorkClass(double value) {

		setAttrib(Consts.A_ROW_WORKCLASS, Double.toString(value));
	}

	@Override
	public Item getWorkers() {

		return this.workers;
	}

	@Override
	public Item getMachines() {

		return this.machines;
	}

	@Override
	public Item getMaterials() {

		return this.materials;
	}

	@Override
	public Item getMechanics() {

		return this.mechanincs;
	}

	@Override
	public Item getWorks() {

		return this.works;
	}

	@Override
	public Item getFactors() {

		return this.factors;
	}

	@Override
	public Item getNotes() {

		return this.notes;
	}

	@Override
	public Item getHistory() {

		return this.history;
	}

	@Override
	public Item getRelativeFactors() {

		return this.relativeFactors;
	}

	@Override
	protected boolean needToSave() {
		return true;
	}

	@Override
	public String getNumber(boolean includeDocumentNumber, boolean includeDocumentTypeName) {
		Chapter parent = (Chapter) getParent();
		
		if (parent != null && parent.isNumberFormative()){
			String number = parent.getNumber(includeDocumentTypeName, includeDocumentNumber);
			if (!number.isEmpty())
				return number + "-" + getCode();
			else
				return getCode();
		}
		return getCode();
	}

	@Override
	public Resource resourceByCode(String code) {
		List<Item> items = getAll(item -> item instanceof Resource, true);
		for (int i = 0; i < items.size(); i++){
			Resource resource = (Resource)items.get(i);
		
			if (resource.getCode().equals(code))
				return resource;
		}		
		return null;
	}

	@Override
	public String getFullCaption() {
		Chapter parent = (Chapter) getParent();
		if (parent != null && parent.isTitleFormative())
			return parent.getCaption() + " " + this.getCaption();
		
		return getCaption();
	}

}
