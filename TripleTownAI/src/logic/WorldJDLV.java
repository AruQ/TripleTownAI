package logic;

public  class WorldJDLV{

public WorldJDLV(){
}
public static java.util.List<Cell> placeCristal(Matrix matrix,Item nextItem){
java.util.List<Item> items=ItemManager.getInstance().getItems();
java.util.List<Cell> cells=matrix.toCells();
String nextItemName=nextItem.getName();
java.util.List<Cell> places= new java.util.ArrayList();

	// ---- START - startProgram ---- 
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Creation placeCristal JDLV module.");
it.unical.mat.wrapper.DLVInputProgram _JDLV_PROGRAM_placeCristal=new it.unical.mat.wrapper.DLVInputProgramImpl();
_JDLV_PROGRAM_placeCristal.cleanText();
java.lang.StringBuffer _JDLV_PROGRAM_BUFFER_placeCristal=new java.lang.StringBuffer();
it.unical.mat.wrapper.DLVInvocation _JDLV_INVOCATION_placeCristal;

	// ---- END - startProgram ---- 

	// ---- START - addInMapping ---- 
_JDLV_PROGRAM_placeCristal.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(cells,"matrix"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'cells::matrix' in module placeCristal:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(cells,"matrix"), 0));

	// ---- END - addInMapping ---- 

	// ---- START - addInMapping ---- 
_JDLV_PROGRAM_placeCristal.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(items,"item"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'items::item' in module placeCristal:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(items,"item"), 0));

	// ---- END - addInMapping ---- 

	// ---- START - addInMapping ---- 
_JDLV_PROGRAM_placeCristal.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(nextItemName,"nextItem"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'nextItemName::nextItem' in module placeCristal:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(nextItemName,"nextItem"), 0));

	// ---- END - addInMapping ---- 
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add out-mapping 'places::place' in module placeCristal.");

	// ---- START - prepareJDLVCall ---- 
try{

_JDLV_INVOCATION_placeCristal=it.unical.mat.wrapper.DLVWrapper.getInstance().createInvocation(it.unical.mat.jdlv.util.JdlvProperties.getInstance().getDlvExecutablePath());
_JDLV_PROGRAM_placeCristal.addText(_JDLV_PROGRAM_BUFFER_placeCristal.toString());
_JDLV_PROGRAM_placeCristal.getFiles().clear();
_JDLV_PROGRAM_placeCristal.addFile("./tripleTownAICristal.dl");
_JDLV_INVOCATION_placeCristal.setNumberOfModels(1);
_JDLV_PROGRAM_BUFFER_placeCristal.append("");
_JDLV_INVOCATION_placeCristal.setInputProgram(_JDLV_PROGRAM_placeCristal);
it.unical.mat.wrapper.ModelBufferedHandler _BUFFERED_HANDLER_placeCristal=new it.unical.mat.wrapper.ModelBufferedHandler(_JDLV_INVOCATION_placeCristal);
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Start execution placeCristal program: executablePath='"+it.unical.mat.jdlv.util.JdlvProperties.getInstance().getDlvExecutablePath()+"', options='"+_JDLV_INVOCATION_placeCristal.getOptionsString()+"'"+'\n'+"Code execution: "+it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(_JDLV_INVOCATION_placeCristal.getInputProgram().getCompleteText(),0)+'\n'+"Files execution: ./tripleTownAICristal.dl");
_JDLV_INVOCATION_placeCristal.run();
while(_BUFFERED_HANDLER_placeCristal.hasMoreModels()){
it.unical.mat.wrapper.Model _temporary_JDLV_MODELplaceCristal=_BUFFERED_HANDLER_placeCristal.nextModel();
it.unical.mat.jdlv.program.TypeSolver.loadPredicate(places, "place",_temporary_JDLV_MODELplaceCristal,Cell.class);
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Process new answer_set"+ '\n' + "Results:"+ '\n'+ "places " + places.size() + " elements"+ '\n' + it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyObject(places,0));
}
if(_JDLV_INVOCATION_placeCristal.haveModel()==false){
}
if(!_JDLV_INVOCATION_placeCristal.getErrors().isEmpty()){
throw new java.lang.RuntimeException(_JDLV_INVOCATION_placeCristal.getErrors().get(0).getText());
}
}
catch(java.lang.Throwable _JDLV_EXCEPTION_placeCristal){
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logErrorMessage(_JDLV_EXCEPTION_placeCristal.getMessage());
}
_JDLV_PROGRAM_placeCristal.cleanText();

	// ---- END - prepareJDLVCall ---- 
return places;
}
public static java.util.List<Cell> update(Matrix matrix,Cell lastAdded){
java.util.List<Cell> cells=matrix.toCells();
java.util.List<Cell> neighbours= new java.util.ArrayList();

	// ---- START - startProgram ---- 
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Creation findNeighbour JDLV module.");
it.unical.mat.wrapper.DLVInputProgram _JDLV_PROGRAM_findNeighbour=new it.unical.mat.wrapper.DLVInputProgramImpl();
_JDLV_PROGRAM_findNeighbour.cleanText();
java.lang.StringBuffer _JDLV_PROGRAM_BUFFER_findNeighbour=new java.lang.StringBuffer();
it.unical.mat.wrapper.DLVInvocation _JDLV_INVOCATION_findNeighbour;

	// ---- END - startProgram ---- 

	// ---- START - addInMapping ---- 
_JDLV_PROGRAM_findNeighbour.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(cells,"matrix"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'cells::matrix' in module findNeighbour:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(cells,"matrix"), 0));

	// ---- END - addInMapping ---- 

	// ---- START - addInMapping ---- 
_JDLV_PROGRAM_findNeighbour.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(lastAdded,"lastAdded"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'lastAdded::lastAdded' in module findNeighbour:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(lastAdded,"lastAdded"), 0));

	// ---- END - addInMapping ---- 
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add out-mapping 'neighbours::neighbour' in module findNeighbour.");

	// ---- START - prepareJDLVCall ---- 
try{

_JDLV_INVOCATION_findNeighbour=it.unical.mat.wrapper.DLVWrapper.getInstance().createInvocation(it.unical.mat.jdlv.util.JdlvProperties.getInstance().getDlvExecutablePath());
_JDLV_PROGRAM_findNeighbour.addText(_JDLV_PROGRAM_BUFFER_findNeighbour.toString());
_JDLV_PROGRAM_findNeighbour.addText("adjacent(X, Y, X, Y1) :- matrix(X, Y, _), matrix(X, Y1, _), Y = Y1 + 1."+'\n');
_JDLV_PROGRAM_findNeighbour.addText("adjacent(X, Y, X1, Y) :- matrix(X, Y, _), matrix(X1, Y, _), X = X1 + 1."+'\n');
_JDLV_PROGRAM_findNeighbour.addText("adjacent(X, Y, X1, Y1) :- adjacent(X1, Y1, X, Y)."+'\n');
_JDLV_PROGRAM_findNeighbour.addText("neighbour(X, Y, T) :- lastAdded(X, Y, T)."+'\n');
_JDLV_PROGRAM_findNeighbour.addText("neighbour(X, Y, T) :- matrix(X, Y, T), neighbour(X1, Y1, T), adjacent(X, Y, X1, Y1)."+'\n');
_JDLV_PROGRAM_findNeighbour.getFiles().clear();
_JDLV_INVOCATION_findNeighbour.setNumberOfModels(1);
_JDLV_PROGRAM_BUFFER_findNeighbour.append("");
_JDLV_INVOCATION_findNeighbour.setInputProgram(_JDLV_PROGRAM_findNeighbour);
it.unical.mat.wrapper.ModelBufferedHandler _BUFFERED_HANDLER_findNeighbour=new it.unical.mat.wrapper.ModelBufferedHandler(_JDLV_INVOCATION_findNeighbour);
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Start execution findNeighbour program: executablePath='"+it.unical.mat.jdlv.util.JdlvProperties.getInstance().getDlvExecutablePath()+"', options='"+_JDLV_INVOCATION_findNeighbour.getOptionsString()+"'"+'\n'+"Code execution: "+it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(_JDLV_INVOCATION_findNeighbour.getInputProgram().getCompleteText(),0));
_JDLV_INVOCATION_findNeighbour.run();
while(_BUFFERED_HANDLER_findNeighbour.hasMoreModels()){
it.unical.mat.wrapper.Model _temporary_JDLV_MODELfindNeighbour=_BUFFERED_HANDLER_findNeighbour.nextModel();
it.unical.mat.jdlv.program.TypeSolver.loadPredicate(neighbours, "neighbour",_temporary_JDLV_MODELfindNeighbour,Cell.class);
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Process new answer_set"+ '\n' + "Results:"+ '\n'+ "neighbours " + neighbours.size() + " elements"+ '\n' + it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyObject(neighbours,0));
}
if(_JDLV_INVOCATION_findNeighbour.haveModel()==false){
}
if(!_JDLV_INVOCATION_findNeighbour.getErrors().isEmpty()){
throw new java.lang.RuntimeException(_JDLV_INVOCATION_findNeighbour.getErrors().get(0).getText());
}
}
catch(java.lang.Throwable _JDLV_EXCEPTION_findNeighbour){
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logErrorMessage(_JDLV_EXCEPTION_findNeighbour.getMessage());
}
_JDLV_PROGRAM_findNeighbour.cleanText();

	// ---- END - prepareJDLVCall ---- 
return neighbours;
}
public static java.util.List<Cell> bearAvaibleMovements(Matrix matrix,Cell bear){
java.util.List<Cell> cells=matrix.toCells();
java.util.List<Cell> avaibleMovements= new java.util.ArrayList();

	// ---- START - startProgram ---- 
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Creation findBearMovements JDLV module.");
it.unical.mat.wrapper.DLVInputProgram _JDLV_PROGRAM_findBearMovements=new it.unical.mat.wrapper.DLVInputProgramImpl();
_JDLV_PROGRAM_findBearMovements.cleanText();
java.lang.StringBuffer _JDLV_PROGRAM_BUFFER_findBearMovements=new java.lang.StringBuffer();
it.unical.mat.wrapper.DLVInvocation _JDLV_INVOCATION_findBearMovements;

	// ---- END - startProgram ---- 

	// ---- START - addInMapping ---- 
_JDLV_PROGRAM_findBearMovements.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(cells,"matrix"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'cells::matrix' in module findBearMovements:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(cells,"matrix"), 0));

	// ---- END - addInMapping ---- 

	// ---- START - addInMapping ---- 
_JDLV_PROGRAM_findBearMovements.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(bear,"bear"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'bear::bear' in module findBearMovements:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(bear,"bear"), 0));

	// ---- END - addInMapping ---- 
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add out-mapping 'avaibleMovements::avaibleMovement' in module findBearMovements.");

	// ---- START - prepareJDLVCall ---- 
try{

_JDLV_INVOCATION_findBearMovements=it.unical.mat.wrapper.DLVWrapper.getInstance().createInvocation(it.unical.mat.jdlv.util.JdlvProperties.getInstance().getDlvExecutablePath());
_JDLV_PROGRAM_findBearMovements.addText(_JDLV_PROGRAM_BUFFER_findBearMovements.toString());
_JDLV_PROGRAM_findBearMovements.addText("adjacent(X, Y, X, Y1) :- matrix(X, Y, _), matrix(X, Y1, _), Y = Y1 + 1."+'\n');
_JDLV_PROGRAM_findBearMovements.addText("adjacent(X, Y, X1, Y) :- matrix(X, Y, _), matrix(X1, Y, _), X = X1 + 1."+'\n');
_JDLV_PROGRAM_findBearMovements.addText("adjacent(X, Y, X1, Y1) :- adjacent(X1, Y1, X, Y)."+'\n');
_JDLV_PROGRAM_findBearMovements.addText("avaibleMovement(X, Y, \"Empty\") :- bear(X1, Y1, _), adjacent(X, Y, X1, Y1), matrix(X, Y, \"Empty\")."+'\n');
_JDLV_PROGRAM_findBearMovements.getFiles().clear();
_JDLV_INVOCATION_findBearMovements.setNumberOfModels(1);
_JDLV_PROGRAM_BUFFER_findBearMovements.append("");
_JDLV_INVOCATION_findBearMovements.setInputProgram(_JDLV_PROGRAM_findBearMovements);
it.unical.mat.wrapper.ModelBufferedHandler _BUFFERED_HANDLER_findBearMovements=new it.unical.mat.wrapper.ModelBufferedHandler(_JDLV_INVOCATION_findBearMovements);
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Start execution findBearMovements program: executablePath='"+it.unical.mat.jdlv.util.JdlvProperties.getInstance().getDlvExecutablePath()+"', options='"+_JDLV_INVOCATION_findBearMovements.getOptionsString()+"'"+'\n'+"Code execution: "+it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(_JDLV_INVOCATION_findBearMovements.getInputProgram().getCompleteText(),0));
_JDLV_INVOCATION_findBearMovements.run();
while(_BUFFERED_HANDLER_findBearMovements.hasMoreModels()){
it.unical.mat.wrapper.Model _temporary_JDLV_MODELfindBearMovements=_BUFFERED_HANDLER_findBearMovements.nextModel();
it.unical.mat.jdlv.program.TypeSolver.loadPredicate(avaibleMovements, "avaibleMovement",_temporary_JDLV_MODELfindBearMovements,Cell.class);
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Process new answer_set"+ '\n' + "Results:"+ '\n'+ "avaibleMovements " + avaibleMovements.size() + " elements"+ '\n' + it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyObject(avaibleMovements,0));
}
if(_JDLV_INVOCATION_findBearMovements.haveModel()==false){
}
if(!_JDLV_INVOCATION_findBearMovements.getErrors().isEmpty()){
throw new java.lang.RuntimeException(_JDLV_INVOCATION_findBearMovements.getErrors().get(0).getText());
}
}
catch(java.lang.Throwable _JDLV_EXCEPTION_findBearMovements){
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logErrorMessage(_JDLV_EXCEPTION_findBearMovements.getMessage());
}
_JDLV_PROGRAM_findBearMovements.cleanText();

	// ---- END - prepareJDLVCall ---- 
return avaibleMovements;
}
public static java.util.List<BearMovement> calculateNewPositionBears(Matrix matrix,java.util.List<Cell> tombstones){
java.util.List<Cell> cells=matrix.toCells();
java.util.List<BearMovement> avaibleMovements= new java.util.ArrayList();

	// ---- START - startProgram ---- 
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Creation findBearMovements JDLV module.");
it.unical.mat.wrapper.DLVInputProgram _JDLV_PROGRAM_findBearMovements=new it.unical.mat.wrapper.DLVInputProgramImpl();
_JDLV_PROGRAM_findBearMovements.cleanText();
java.lang.StringBuffer _JDLV_PROGRAM_BUFFER_findBearMovements=new java.lang.StringBuffer();
it.unical.mat.wrapper.DLVInvocation _JDLV_INVOCATION_findBearMovements;

	// ---- END - startProgram ---- 

	// ---- START - addInMapping ---- 
_JDLV_PROGRAM_findBearMovements.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(cells,"matrix"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'cells::matrix' in module findBearMovements:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(cells,"matrix"), 0));

	// ---- END - addInMapping ---- 
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add out-mapping 'avaibleMovements::move' in module findBearMovements.");
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add out-mapping 'tombstones::tombstone' in module findBearMovements.");

	// ---- START - prepareJDLVCall ---- 
try{

_JDLV_INVOCATION_findBearMovements=it.unical.mat.wrapper.DLVWrapper.getInstance().createInvocation(it.unical.mat.jdlv.util.JdlvProperties.getInstance().getDlvExecutablePath());
_JDLV_PROGRAM_findBearMovements.addText(_JDLV_PROGRAM_BUFFER_findBearMovements.toString());
_JDLV_PROGRAM_findBearMovements.addText("move(X, Y, X1, Y1) v notMove(X, Y, X1, Y1) :- matrix(X, Y, \"Bear\"), adjacent(X, Y, X1, Y1)."+'\n');
_JDLV_PROGRAM_findBearMovements.addText(":- move(X1, Y1, X2, Y2), move(X2, Y2, X1, Y1)."+'\n');
_JDLV_PROGRAM_findBearMovements.addText(":- move(X1, Y1, X2, Y2), from(X3, Y3, X2, Y2), X3 != X1."+'\n');
_JDLV_PROGRAM_findBearMovements.addText(":- move(X1, Y1, X2, Y2), from(X3, Y3, X2, Y2), Y3 != Y1."+'\n');
_JDLV_PROGRAM_findBearMovements.addText(":- #count{X2,Y2 : move(X1, Y1, X2, Y2)} > 1, matrix(X1, Y1, \"Bear\")."+'\n');
_JDLV_PROGRAM_findBearMovements.addText("freeCell(X, Y) :- move(X, Y, _, _)."+'\n');
_JDLV_PROGRAM_findBearMovements.addText("freeCell(X, Y) :- matrix(X, Y, \"Empty\")."+'\n');
_JDLV_PROGRAM_findBearMovements.addText(":- move(X, Y, X1, Y1), not freeCell(X1, Y1)."+'\n');
_JDLV_PROGRAM_findBearMovements.addText("adjacent(X, Y, X, Y1) :- matrix(X, Y, _), matrix(X, Y1, _), Y = Y1 + 1."+'\n');
_JDLV_PROGRAM_findBearMovements.addText("adjacent(X, Y, X1, Y) :- matrix(X, Y, _), matrix(X1, Y, _), X = X1 + 1."+'\n');
_JDLV_PROGRAM_findBearMovements.addText("adjacent(X, Y, X1, Y1) :- adjacent(X1, Y1, X, Y)."+'\n');
_JDLV_PROGRAM_findBearMovements.addText("movedBear(X, Y) :- move(X, Y, X2, Y2)."+'\n');
_JDLV_PROGRAM_findBearMovements.addText("tombstone(X, Y, \"Tombstone\") :- matrix(X, Y, \"Bear\"), not movedBear(X, Y)."+'\n');
_JDLV_PROGRAM_findBearMovements.getFiles().clear();
_JDLV_INVOCATION_findBearMovements.setNumberOfModels(1);
_JDLV_PROGRAM_BUFFER_findBearMovements.append("");
_JDLV_INVOCATION_findBearMovements.setInputProgram(_JDLV_PROGRAM_findBearMovements);
it.unical.mat.wrapper.ModelBufferedHandler _BUFFERED_HANDLER_findBearMovements=new it.unical.mat.wrapper.ModelBufferedHandler(_JDLV_INVOCATION_findBearMovements);
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Start execution findBearMovements program: executablePath='"+it.unical.mat.jdlv.util.JdlvProperties.getInstance().getDlvExecutablePath()+"', options='"+_JDLV_INVOCATION_findBearMovements.getOptionsString()+"'"+'\n'+"Code execution: "+it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(_JDLV_INVOCATION_findBearMovements.getInputProgram().getCompleteText(),0));
_JDLV_INVOCATION_findBearMovements.run();
while(_BUFFERED_HANDLER_findBearMovements.hasMoreModels()){
it.unical.mat.wrapper.Model _temporary_JDLV_MODELfindBearMovements=_BUFFERED_HANDLER_findBearMovements.nextModel();
it.unical.mat.jdlv.program.TypeSolver.loadPredicate(avaibleMovements, "move",_temporary_JDLV_MODELfindBearMovements,BearMovement.class);
it.unical.mat.jdlv.program.TypeSolver.loadPredicate(tombstones, "tombstone",_temporary_JDLV_MODELfindBearMovements,Cell.class);
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Process new answer_set"+ '\n' + "Results:"+ '\n'+ "avaibleMovements " + avaibleMovements.size() + " elements"+ '\n' + it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyObject(avaibleMovements,0)+ "tombstones " + tombstones.size() + " elements"+ '\n' + it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyObject(tombstones,0));
}
if(_JDLV_INVOCATION_findBearMovements.haveModel()==false){
}
if(!_JDLV_INVOCATION_findBearMovements.getErrors().isEmpty()){
throw new java.lang.RuntimeException(_JDLV_INVOCATION_findBearMovements.getErrors().get(0).getText());
}
}
catch(java.lang.Throwable _JDLV_EXCEPTION_findBearMovements){
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logErrorMessage(_JDLV_EXCEPTION_findBearMovements.getMessage());
}
_JDLV_PROGRAM_findBearMovements.cleanText();

	// ---- END - prepareJDLVCall ---- 
return avaibleMovements;
}
public static java.util.List<Cell> aiPlayer(Matrix matrix,java.util.List<Cell> maxElems,Item nextItem){
java.util.List<Item> items=ItemManager.getInstance().getItems();
java.util.List<Cell> cells=matrix.toCells();
String nextItemName=nextItem.getName();
java.util.List<Cell> places= new java.util.ArrayList();

	// ---- START - startProgram ---- 
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Creation aiPlayer JDLV module.");
it.unical.mat.wrapper.DLVInputProgram _JDLV_PROGRAM_aiPlayer=new it.unical.mat.wrapper.DLVInputProgramImpl();
_JDLV_PROGRAM_aiPlayer.cleanText();
java.lang.StringBuffer _JDLV_PROGRAM_BUFFER_aiPlayer=new java.lang.StringBuffer();
it.unical.mat.wrapper.DLVInvocation _JDLV_INVOCATION_aiPlayer;

	// ---- END - startProgram ---- 

	// ---- START - addInMapping ---- 
_JDLV_PROGRAM_aiPlayer.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(cells,"matrix"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'cells::matrix' in module aiPlayer:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(cells,"matrix"), 0));

	// ---- END - addInMapping ---- 

	// ---- START - addInMapping ---- 
_JDLV_PROGRAM_aiPlayer.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(items,"item"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'items::item' in module aiPlayer:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(items,"item"), 0));

	// ---- END - addInMapping ---- 

	// ---- START - addInMapping ---- 
_JDLV_PROGRAM_aiPlayer.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(nextItemName,"nextItem"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'nextItemName::nextItem' in module aiPlayer:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(nextItemName,"nextItem"), 0));

	// ---- END - addInMapping ---- 

	// ---- START - addInMapping ---- 
_JDLV_PROGRAM_aiPlayer.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(maxElems,"maxElement"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'maxElems::maxElement' in module aiPlayer:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(maxElems,"maxElement"), 0));

	// ---- END - addInMapping ---- 
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add out-mapping 'places::place' in module aiPlayer.");

	// ---- START - prepareJDLVCall ---- 
try{

_JDLV_INVOCATION_aiPlayer=it.unical.mat.wrapper.DLVWrapper.getInstance().createInvocation(it.unical.mat.jdlv.util.JdlvProperties.getInstance().getDlvExecutablePath());
_JDLV_PROGRAM_aiPlayer.addText(_JDLV_PROGRAM_BUFFER_aiPlayer.toString());
_JDLV_PROGRAM_aiPlayer.getFiles().clear();
_JDLV_PROGRAM_aiPlayer.addFile("./tripleTownAI.dl");
_JDLV_INVOCATION_aiPlayer.setNumberOfModels(1);
_JDLV_PROGRAM_BUFFER_aiPlayer.append("");
_JDLV_INVOCATION_aiPlayer.setInputProgram(_JDLV_PROGRAM_aiPlayer);
it.unical.mat.wrapper.ModelBufferedHandler _BUFFERED_HANDLER_aiPlayer=new it.unical.mat.wrapper.ModelBufferedHandler(_JDLV_INVOCATION_aiPlayer);
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Start execution aiPlayer program: executablePath='"+it.unical.mat.jdlv.util.JdlvProperties.getInstance().getDlvExecutablePath()+"', options='"+_JDLV_INVOCATION_aiPlayer.getOptionsString()+"'"+'\n'+"Code execution: "+it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(_JDLV_INVOCATION_aiPlayer.getInputProgram().getCompleteText(),0)+'\n'+"Files execution: ./tripleTownAI.dl");
_JDLV_INVOCATION_aiPlayer.run();
while(_BUFFERED_HANDLER_aiPlayer.hasMoreModels()){
it.unical.mat.wrapper.Model _temporary_JDLV_MODELaiPlayer=_BUFFERED_HANDLER_aiPlayer.nextModel();
it.unical.mat.jdlv.program.TypeSolver.loadPredicate(places, "place",_temporary_JDLV_MODELaiPlayer,Cell.class);
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Process new answer_set"+ '\n' + "Results:"+ '\n'+ "places " + places.size() + " elements"+ '\n' + it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyObject(places,0));
}
if(_JDLV_INVOCATION_aiPlayer.haveModel()==false){
}
if(!_JDLV_INVOCATION_aiPlayer.getErrors().isEmpty()){
throw new java.lang.RuntimeException(_JDLV_INVOCATION_aiPlayer.getErrors().get(0).getText());
}
}
catch(java.lang.Throwable _JDLV_EXCEPTION_aiPlayer){
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logErrorMessage(_JDLV_EXCEPTION_aiPlayer.getMessage());
}
_JDLV_PROGRAM_aiPlayer.cleanText();

	// ---- END - prepareJDLVCall ---- 
return places;
}
}

