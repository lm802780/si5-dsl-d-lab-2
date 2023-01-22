// Generated from ../antlr/src/main/antlr4/io/github/d/lab2/externals/antlr/grammar/Notebookml.g4 by ANTLR 4.7.3-SNAPSHOT


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
import {ParseTreeListener} from "antlr4ts/tree";


/**
 * This interface defines a complete listener for a parse tree produced by
 * `NotebookmlParser`.
 */
export interface NotebookmlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by `NotebookmlParser.root`.
	 * @param ctx the parse tree
	 */
	enterRoot?: (ctx: RootContext) => void;
	/**
	 * Exit a parse tree produced by `NotebookmlParser.root`.
	 * @param ctx the parse tree
	 */
	exitRoot?: (ctx: RootContext) => void;
	/**
	 * Enter a parse tree produced by `NotebookmlParser.description`.
	 * @param ctx the parse tree
	 */
	enterDescription?: (ctx: DescriptionContext) => void;
	/**
	 * Exit a parse tree produced by `NotebookmlParser.description`.
	 * @param ctx the parse tree
	 */
	exitDescription?: (ctx: DescriptionContext) => void;
	/**
	 * Enter a parse tree produced by `NotebookmlParser.frameworks`.
	 * @param ctx the parse tree
	 */
	enterFrameworks?: (ctx: FrameworksContext) => void;
	/**
	 * Exit a parse tree produced by `NotebookmlParser.frameworks`.
	 * @param ctx the parse tree
	 */
	exitFrameworks?: (ctx: FrameworksContext) => void;
	/**
	 * Enter a parse tree produced by `NotebookmlParser.framework`.
	 * @param ctx the parse tree
	 */
	enterFramework?: (ctx: FrameworkContext) => void;
	/**
	 * Exit a parse tree produced by `NotebookmlParser.framework`.
	 * @param ctx the parse tree
	 */
	exitFramework?: (ctx: FrameworkContext) => void;
	/**
	 * Enter a parse tree produced by `NotebookmlParser.workflow`.
	 * @param ctx the parse tree
	 */
	enterWorkflow?: (ctx: WorkflowContext) => void;
	/**
	 * Exit a parse tree produced by `NotebookmlParser.workflow`.
	 * @param ctx the parse tree
	 */
	exitWorkflow?: (ctx: WorkflowContext) => void;
	/**
	 * Enter a parse tree produced by `NotebookmlParser.selection`.
	 * @param ctx the parse tree
	 */
	enterSelection?: (ctx: SelectionContext) => void;
	/**
	 * Exit a parse tree produced by `NotebookmlParser.selection`.
	 * @param ctx the parse tree
	 */
	exitSelection?: (ctx: SelectionContext) => void;
	/**
	 * Enter a parse tree produced by `NotebookmlParser.source`.
	 * @param ctx the parse tree
	 */
	enterSource?: (ctx: SourceContext) => void;
	/**
	 * Exit a parse tree produced by `NotebookmlParser.source`.
	 * @param ctx the parse tree
	 */
	exitSource?: (ctx: SourceContext) => void;
	/**
	 * Enter a parse tree produced by `NotebookmlParser.label`.
	 * @param ctx the parse tree
	 */
	enterLabel?: (ctx: LabelContext) => void;
	/**
	 * Exit a parse tree produced by `NotebookmlParser.label`.
	 * @param ctx the parse tree
	 */
	exitLabel?: (ctx: LabelContext) => void;
	/**
	 * Enter a parse tree produced by `NotebookmlParser.split`.
	 * @param ctx the parse tree
	 */
	enterSplit?: (ctx: SplitContext) => void;
	/**
	 * Exit a parse tree produced by `NotebookmlParser.split`.
	 * @param ctx the parse tree
	 */
	exitSplit?: (ctx: SplitContext) => void;
	/**
	 * Enter a parse tree produced by `NotebookmlParser.split_list`.
	 * @param ctx the parse tree
	 */
	enterSplit_list?: (ctx: Split_listContext) => void;
	/**
	 * Exit a parse tree produced by `NotebookmlParser.split_list`.
	 * @param ctx the parse tree
	 */
	exitSplit_list?: (ctx: Split_listContext) => void;
	/**
	 * Enter a parse tree produced by `NotebookmlParser.preProcessing`.
	 * @param ctx the parse tree
	 */
	enterPreProcessing?: (ctx: PreProcessingContext) => void;
	/**
	 * Exit a parse tree produced by `NotebookmlParser.preProcessing`.
	 * @param ctx the parse tree
	 */
	exitPreProcessing?: (ctx: PreProcessingContext) => void;
	/**
	 * Enter a parse tree produced by `NotebookmlParser.nan`.
	 * @param ctx the parse tree
	 */
	enterNan?: (ctx: NanContext) => void;
	/**
	 * Exit a parse tree produced by `NotebookmlParser.nan`.
	 * @param ctx the parse tree
	 */
	exitNan?: (ctx: NanContext) => void;
	/**
	 * Enter a parse tree produced by `NotebookmlParser.transformation`.
	 * @param ctx the parse tree
	 */
	enterTransformation?: (ctx: TransformationContext) => void;
	/**
	 * Exit a parse tree produced by `NotebookmlParser.transformation`.
	 * @param ctx the parse tree
	 */
	exitTransformation?: (ctx: TransformationContext) => void;
	/**
	 * Enter a parse tree produced by `NotebookmlParser.reshape`.
	 * @param ctx the parse tree
	 */
	enterReshape?: (ctx: ReshapeContext) => void;
	/**
	 * Exit a parse tree produced by `NotebookmlParser.reshape`.
	 * @param ctx the parse tree
	 */
	exitReshape?: (ctx: ReshapeContext) => void;
	/**
	 * Enter a parse tree produced by `NotebookmlParser.reshape_values`.
	 * @param ctx the parse tree
	 */
	enterReshape_values?: (ctx: Reshape_valuesContext) => void;
	/**
	 * Exit a parse tree produced by `NotebookmlParser.reshape_values`.
	 * @param ctx the parse tree
	 */
	exitReshape_values?: (ctx: Reshape_valuesContext) => void;
	/**
	 * Enter a parse tree produced by `NotebookmlParser.normalization`.
	 * @param ctx the parse tree
	 */
	enterNormalization?: (ctx: NormalizationContext) => void;
	/**
	 * Exit a parse tree produced by `NotebookmlParser.normalization`.
	 * @param ctx the parse tree
	 */
	exitNormalization?: (ctx: NormalizationContext) => void;
	/**
	 * Enter a parse tree produced by `NotebookmlParser.normalization_elem`.
	 * @param ctx the parse tree
	 */
	enterNormalization_elem?: (ctx: Normalization_elemContext) => void;
	/**
	 * Exit a parse tree produced by `NotebookmlParser.normalization_elem`.
	 * @param ctx the parse tree
	 */
	exitNormalization_elem?: (ctx: Normalization_elemContext) => void;
	/**
	 * Enter a parse tree produced by `NotebookmlParser.data_mining`.
	 * @param ctx the parse tree
	 */
	enterData_mining?: (ctx: Data_miningContext) => void;
	/**
	 * Exit a parse tree produced by `NotebookmlParser.data_mining`.
	 * @param ctx the parse tree
	 */
	exitData_mining?: (ctx: Data_miningContext) => void;
	/**
	 * Enter a parse tree produced by `NotebookmlParser.network`.
	 * @param ctx the parse tree
	 */
	enterNetwork?: (ctx: NetworkContext) => void;
	/**
	 * Exit a parse tree produced by `NotebookmlParser.network`.
	 * @param ctx the parse tree
	 */
	exitNetwork?: (ctx: NetworkContext) => void;
	/**
	 * Enter a parse tree produced by `NotebookmlParser.sequential`.
	 * @param ctx the parse tree
	 */
	enterSequential?: (ctx: SequentialContext) => void;
	/**
	 * Exit a parse tree produced by `NotebookmlParser.sequential`.
	 * @param ctx the parse tree
	 */
	exitSequential?: (ctx: SequentialContext) => void;
	/**
	 * Enter a parse tree produced by `NotebookmlParser.linear`.
	 * @param ctx the parse tree
	 */
	enterLinear?: (ctx: LinearContext) => void;
	/**
	 * Exit a parse tree produced by `NotebookmlParser.linear`.
	 * @param ctx the parse tree
	 */
	exitLinear?: (ctx: LinearContext) => void;
	/**
	 * Enter a parse tree produced by `NotebookmlParser.tanh`.
	 * @param ctx the parse tree
	 */
	enterTanh?: (ctx: TanhContext) => void;
	/**
	 * Exit a parse tree produced by `NotebookmlParser.tanh`.
	 * @param ctx the parse tree
	 */
	exitTanh?: (ctx: TanhContext) => void;
	/**
	 * Enter a parse tree produced by `NotebookmlParser.softmax`.
	 * @param ctx the parse tree
	 */
	enterSoftmax?: (ctx: SoftmaxContext) => void;
	/**
	 * Exit a parse tree produced by `NotebookmlParser.softmax`.
	 * @param ctx the parse tree
	 */
	exitSoftmax?: (ctx: SoftmaxContext) => void;
	/**
	 * Enter a parse tree produced by `NotebookmlParser.params`.
	 * @param ctx the parse tree
	 */
	enterParams?: (ctx: ParamsContext) => void;
	/**
	 * Exit a parse tree produced by `NotebookmlParser.params`.
	 * @param ctx the parse tree
	 */
	exitParams?: (ctx: ParamsContext) => void;
	/**
	 * Enter a parse tree produced by `NotebookmlParser.loss`.
	 * @param ctx the parse tree
	 */
	enterLoss?: (ctx: LossContext) => void;
	/**
	 * Exit a parse tree produced by `NotebookmlParser.loss`.
	 * @param ctx the parse tree
	 */
	exitLoss?: (ctx: LossContext) => void;
	/**
	 * Enter a parse tree produced by `NotebookmlParser.optimizers`.
	 * @param ctx the parse tree
	 */
	enterOptimizers?: (ctx: OptimizersContext) => void;
	/**
	 * Exit a parse tree produced by `NotebookmlParser.optimizers`.
	 * @param ctx the parse tree
	 */
	exitOptimizers?: (ctx: OptimizersContext) => void;
	/**
	 * Enter a parse tree produced by `NotebookmlParser.learningRate`.
	 * @param ctx the parse tree
	 */
	enterLearningRate?: (ctx: LearningRateContext) => void;
	/**
	 * Exit a parse tree produced by `NotebookmlParser.learningRate`.
	 * @param ctx the parse tree
	 */
	exitLearningRate?: (ctx: LearningRateContext) => void;
	/**
	 * Enter a parse tree produced by `NotebookmlParser.nbEpochs`.
	 * @param ctx the parse tree
	 */
	enterNbEpochs?: (ctx: NbEpochsContext) => void;
	/**
	 * Exit a parse tree produced by `NotebookmlParser.nbEpochs`.
	 * @param ctx the parse tree
	 */
	exitNbEpochs?: (ctx: NbEpochsContext) => void;
	/**
	 * Enter a parse tree produced by `NotebookmlParser.batchSize`.
	 * @param ctx the parse tree
	 */
	enterBatchSize?: (ctx: BatchSizeContext) => void;
	/**
	 * Exit a parse tree produced by `NotebookmlParser.batchSize`.
	 * @param ctx the parse tree
	 */
	exitBatchSize?: (ctx: BatchSizeContext) => void;
	/**
	 * Enter a parse tree produced by `NotebookmlParser.validation`.
	 * @param ctx the parse tree
	 */
	enterValidation?: (ctx: ValidationContext) => void;
	/**
	 * Exit a parse tree produced by `NotebookmlParser.validation`.
	 * @param ctx the parse tree
	 */
	exitValidation?: (ctx: ValidationContext) => void;
	/**
	 * Enter a parse tree produced by `NotebookmlParser.diagram`.
	 * @param ctx the parse tree
	 */
	enterDiagram?: (ctx: DiagramContext) => void;
	/**
	 * Exit a parse tree produced by `NotebookmlParser.diagram`.
	 * @param ctx the parse tree
	 */
	exitDiagram?: (ctx: DiagramContext) => void;
	/**
	 * Enter a parse tree produced by `NotebookmlParser.score`.
	 * @param ctx the parse tree
	 */
	enterScore?: (ctx: ScoreContext) => void;
	/**
	 * Exit a parse tree produced by `NotebookmlParser.score`.
	 * @param ctx the parse tree
	 */
	exitScore?: (ctx: ScoreContext) => void;
}

