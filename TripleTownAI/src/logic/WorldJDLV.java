package logic;

public  class WorldJDLV{

public WorldJDLV(){
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
}

