package logic;

import java.util.ArrayList;
import java.util.List;


public  class World{

	logic.Matrix matrix = new Matrix();

	public World()
	{
	}

	public List<logic.Cell> update(Cell lastAdded)
	{
		List<logic.Cell> cells = matrix.toCells();
		List<logic.Cell> neighbours = new ArrayList();

		// ---- START - startProgram ----
		it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage(
				"Creation findNeighbour JDLV module.");
		it.unical.mat.wrapper.DLVInputProgram _JDLV_PROGRAM_findNeighbour = new it.unical.mat.wrapper.DLVInputProgramImpl();
		_JDLV_PROGRAM_findNeighbour.cleanText();
		java.lang.StringBuffer _JDLV_PROGRAM_BUFFER_findNeighbour = new java.lang.StringBuffer();
		it.unical.mat.wrapper.DLVInvocation _JDLV_INVOCATION_findNeighbour;

		// ---- END - startProgram ----

		// ---- START - addInMapping ----
		_JDLV_PROGRAM_findNeighbour.addText(it.unical.mat.jdlv.program.TypeSolver
				.getNameTranslation(cells, "matrix"));
		it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage(
				"Add in-mapping 'cells::matrix' in module findNeighbour:"
						+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(
								it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(cells,
										"matrix"), 0));

		// ---- END - addInMapping ----

		// ---- START - addInMapping ----
		_JDLV_PROGRAM_findNeighbour.addText(it.unical.mat.jdlv.program.TypeSolver
				.getNameTranslation(lastAdded, "lastAdded"));
		it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage(
				"Add in-mapping 'lastAdded::lastAdded' in module findNeighbour:"
						+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(
								it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(lastAdded,
										"lastAdded"), 0));

		// ---- END - addInMapping ----
		it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage(
				"Add out-mapping 'neighbours::neighbour' in module findNeighbour.");

		// ---- START - prepareJDLVCall ----
		try
		{

			_JDLV_INVOCATION_findNeighbour = it.unical.mat.wrapper.DLVWrapper.getInstance()
					.createInvocation(
							it.unical.mat.jdlv.util.JdlvProperties.getInstance()
									.getDlvExecutablePath());
			_JDLV_PROGRAM_findNeighbour.addText(_JDLV_PROGRAM_BUFFER_findNeighbour.toString());
			_JDLV_PROGRAM_findNeighbour
					.addText("adjacent(X, Y, X, Y1) :- matrix(X, Y, _), matrix(X, Y1, _), Y = Y1 + 1." + '\n');
			_JDLV_PROGRAM_findNeighbour
					.addText("adjacent(X, Y, X1, Y) :- matrix(X, Y, _), matrix(X1, Y, _), X = X1 + 1." + '\n');
			_JDLV_PROGRAM_findNeighbour
					.addText("adjacent(X, Y, X1, Y1) :- adjacent(X1, Y1, X, Y)." + '\n');
			_JDLV_PROGRAM_findNeighbour.addText("neighbour(X, Y, T) :- lastAdded(X, Y, T)." + '\n');
			_JDLV_PROGRAM_findNeighbour
					.addText("neighbour(X, Y, T) :- matrix(X, Y, T), neighbour(X1, Y1, T), adjacent(X, Y, X1, Y1)." + '\n');
			_JDLV_PROGRAM_findNeighbour.getFiles().clear();
			_JDLV_INVOCATION_findNeighbour.setNumberOfModels(1);
			_JDLV_PROGRAM_BUFFER_findNeighbour.append("");
			_JDLV_INVOCATION_findNeighbour.setInputProgram(_JDLV_PROGRAM_findNeighbour);
			it.unical.mat.wrapper.ModelBufferedHandler _BUFFERED_HANDLER_findNeighbour = new it.unical.mat.wrapper.ModelBufferedHandler(
					_JDLV_INVOCATION_findNeighbour);
			it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage(
					"Start execution findNeighbour program: executablePath='"
							+ it.unical.mat.jdlv.util.JdlvProperties.getInstance()
									.getDlvExecutablePath()
							+ "', options='"
							+ _JDLV_INVOCATION_findNeighbour.getOptionsString()
							+ "'"
							+ '\n'
							+ "Code execution: "
							+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(
									_JDLV_INVOCATION_findNeighbour.getInputProgram()
											.getCompleteText(), 0));
			_JDLV_INVOCATION_findNeighbour.run();
			while (_BUFFERED_HANDLER_findNeighbour.hasMoreModels())
			{
				it.unical.mat.wrapper.Model _temporary_JDLV_MODELfindNeighbour = _BUFFERED_HANDLER_findNeighbour
						.nextModel();
				it.unical.mat.jdlv.program.TypeSolver.loadPredicate(neighbours, "neighbour",
						_temporary_JDLV_MODELfindNeighbour, logic.Cell.class);
				it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage(
						"Process new answer_set"
								+ '\n'
								+ "Results:"
								+ '\n'
								+ "neighbours "
								+ neighbours.size()
								+ " elements"
								+ '\n'
								+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance()
										.getPrettyObject(neighbours, 0));
			}
			if (_JDLV_INVOCATION_findNeighbour.haveModel() == false)
			{}
			if (!_JDLV_INVOCATION_findNeighbour.getErrors().isEmpty())
			{
				throw new java.lang.RuntimeException(_JDLV_INVOCATION_findNeighbour.getErrors()
						.get(0).getText());
			}
		} catch (java.lang.Throwable _JDLV_EXCEPTION_findNeighbour)
		{
			it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logErrorMessage(
					_JDLV_EXCEPTION_findNeighbour.getMessage());
		}
		_JDLV_PROGRAM_findNeighbour.cleanText();

		// ---- END - prepareJDLVCall ----
		return neighbours;
	}
}

