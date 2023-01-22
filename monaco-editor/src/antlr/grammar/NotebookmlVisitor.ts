// Generated from ../antlr/src/main/antlr4/io/github/d/lab2/externals/antlr/grammar/Notebookml.g4 by ANTLR 4.7.3-SNAPSHOT


import { ParseTreeVisitor } from "antlr4ts/tree";

import { RootContext } from "./NotebookmlParser";
import { DescriptionContext } from "./NotebookmlParser";
import { FrameworksContext } from "./NotebookmlParser";
import { FrameworkContext } from "./NotebookmlParser";
import { WorkflowContext } from "./NotebookmlParser";
import { SelectionContext } from "./NotebookmlParser";
import { SourceContext } from "./NotebookmlParser";
import { LabelContext } from "./NotebookmlParser";
import { SplitContext } from "./NotebookmlParser";
import { Split_listContext } from "./NotebookmlParser";
import { PreProcessingContext } from "./NotebookmlParser";
import { NanContext } from "./NotebookmlParser";
import { TransformationContext } from "./NotebookmlParser";
import { ReshapeContext } from "./NotebookmlParser";
import { Reshape_valuesContext } from "./NotebookmlParser";
import { NormalizationContext } from "./NotebookmlParser";
import { Normalization_elemContext } from "./NotebookmlParser";
import { Data_miningContext } from "./NotebookmlParser";
import { NetworkContext } from "./NotebookmlParser";
import { SequentialContext } from "./NotebookmlParser";
import { LinearContext } from "./NotebookmlParser";
import { TanhContext } from "./NotebookmlParser";
import { SoftmaxContext } from "./NotebookmlParser";
import { ParamsContext } from "./NotebookmlParser";
import { LossContext } from "./NotebookmlParser";
import { OptimizersContext } from "./NotebookmlParser";
import { LearningRateContext } from "./NotebookmlParser";
import { NbEpochsContext } from "./NotebookmlParser";
import { BatchSizeContext } from "./NotebookmlParser";
import { ValidationContext } from "./NotebookmlParser";
import { DiagramContext } from "./NotebookmlParser";
import { ScoreContext } from "./NotebookmlParser";


/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by `NotebookmlParser`.
 *
 * @param <Result> The return type of the visit operation. Use `void` for
 * operations with no return type.
 */
export interface NotebookmlVisitor<Result> extends ParseTreeVisitor<Result> {
	/**
	 * Visit a parse tree produced by `NotebookmlParser.root`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitRoot?: (ctx: RootContext) => Result;
	/**
	 * Visit a parse tree produced by `NotebookmlParser.description`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitDescription?: (ctx: DescriptionContext) => Result;
	/**
	 * Visit a parse tree produced by `NotebookmlParser.frameworks`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitFrameworks?: (ctx: FrameworksContext) => Result;
	/**
	 * Visit a parse tree produced by `NotebookmlParser.framework`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitFramework?: (ctx: FrameworkContext) => Result;
	/**
	 * Visit a parse tree produced by `NotebookmlParser.workflow`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitWorkflow?: (ctx: WorkflowContext) => Result;
	/**
	 * Visit a parse tree produced by `NotebookmlParser.selection`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitSelection?: (ctx: SelectionContext) => Result;
	/**
	 * Visit a parse tree produced by `NotebookmlParser.source`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitSource?: (ctx: SourceContext) => Result;
	/**
	 * Visit a parse tree produced by `NotebookmlParser.label`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitLabel?: (ctx: LabelContext) => Result;
	/**
	 * Visit a parse tree produced by `NotebookmlParser.split`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitSplit?: (ctx: SplitContext) => Result;
	/**
	 * Visit a parse tree produced by `NotebookmlParser.split_list`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitSplit_list?: (ctx: Split_listContext) => Result;
	/**
	 * Visit a parse tree produced by `NotebookmlParser.preProcessing`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitPreProcessing?: (ctx: PreProcessingContext) => Result;
	/**
	 * Visit a parse tree produced by `NotebookmlParser.nan`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitNan?: (ctx: NanContext) => Result;
	/**
	 * Visit a parse tree produced by `NotebookmlParser.transformation`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitTransformation?: (ctx: TransformationContext) => Result;
	/**
	 * Visit a parse tree produced by `NotebookmlParser.reshape`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitReshape?: (ctx: ReshapeContext) => Result;
	/**
	 * Visit a parse tree produced by `NotebookmlParser.reshape_values`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitReshape_values?: (ctx: Reshape_valuesContext) => Result;
	/**
	 * Visit a parse tree produced by `NotebookmlParser.normalization`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitNormalization?: (ctx: NormalizationContext) => Result;
	/**
	 * Visit a parse tree produced by `NotebookmlParser.normalization_elem`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitNormalization_elem?: (ctx: Normalization_elemContext) => Result;
	/**
	 * Visit a parse tree produced by `NotebookmlParser.data_mining`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitData_mining?: (ctx: Data_miningContext) => Result;
	/**
	 * Visit a parse tree produced by `NotebookmlParser.network`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitNetwork?: (ctx: NetworkContext) => Result;
	/**
	 * Visit a parse tree produced by `NotebookmlParser.sequential`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitSequential?: (ctx: SequentialContext) => Result;
	/**
	 * Visit a parse tree produced by `NotebookmlParser.linear`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitLinear?: (ctx: LinearContext) => Result;
	/**
	 * Visit a parse tree produced by `NotebookmlParser.tanh`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitTanh?: (ctx: TanhContext) => Result;
	/**
	 * Visit a parse tree produced by `NotebookmlParser.softmax`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitSoftmax?: (ctx: SoftmaxContext) => Result;
	/**
	 * Visit a parse tree produced by `NotebookmlParser.params`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitParams?: (ctx: ParamsContext) => Result;
	/**
	 * Visit a parse tree produced by `NotebookmlParser.loss`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitLoss?: (ctx: LossContext) => Result;
	/**
	 * Visit a parse tree produced by `NotebookmlParser.optimizers`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitOptimizers?: (ctx: OptimizersContext) => Result;
	/**
	 * Visit a parse tree produced by `NotebookmlParser.learningRate`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitLearningRate?: (ctx: LearningRateContext) => Result;
	/**
	 * Visit a parse tree produced by `NotebookmlParser.nbEpochs`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitNbEpochs?: (ctx: NbEpochsContext) => Result;
	/**
	 * Visit a parse tree produced by `NotebookmlParser.batchSize`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitBatchSize?: (ctx: BatchSizeContext) => Result;
	/**
	 * Visit a parse tree produced by `NotebookmlParser.validation`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitValidation?: (ctx: ValidationContext) => Result;
	/**
	 * Visit a parse tree produced by `NotebookmlParser.diagram`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitDiagram?: (ctx: DiagramContext) => Result;
	/**
	 * Visit a parse tree produced by `NotebookmlParser.score`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitScore?: (ctx: ScoreContext) => Result;
}

