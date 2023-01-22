// Generated from ../antlr/src/main/antlr4/io/github/d/lab2/externals/antlr/grammar/Notebookml.g4 by ANTLR 4.7.3-SNAPSHOT


import { ATN } from "antlr4ts/atn";
import { ATNDeserializer } from "antlr4ts/atn";
import { NoViableAltException } from "antlr4ts";
import { Parser } from "antlr4ts";
import { ParserRuleContext } from "antlr4ts";
import { ParserATNSimulator } from "antlr4ts/atn";
import { RecognitionException } from "antlr4ts";
import { TerminalNode } from "antlr4ts/tree";
import { Token } from "antlr4ts";
import { TokenStream } from "antlr4ts";
import { Vocabulary } from "antlr4ts";
import { VocabularyImpl } from "antlr4ts";

import * as Utils from "antlr4ts";

import { NotebookmlListener } from "./NotebookmlListener";
import { NotebookmlVisitor } from "./NotebookmlVisitor";


export class NotebookmlParser extends Parser {
	public static readonly T__0 = 1;
	public static readonly T__1 = 2;
	public static readonly T__2 = 3;
	public static readonly T__3 = 4;
	public static readonly T__4 = 5;
	public static readonly T__5 = 6;
	public static readonly T__6 = 7;
	public static readonly T__7 = 8;
	public static readonly T__8 = 9;
	public static readonly T__9 = 10;
	public static readonly T__10 = 11;
	public static readonly T__11 = 12;
	public static readonly T__12 = 13;
	public static readonly T__13 = 14;
	public static readonly T__14 = 15;
	public static readonly T__15 = 16;
	public static readonly T__16 = 17;
	public static readonly T__17 = 18;
	public static readonly T__18 = 19;
	public static readonly T__19 = 20;
	public static readonly T__20 = 21;
	public static readonly T__21 = 22;
	public static readonly T__22 = 23;
	public static readonly T__23 = 24;
	public static readonly T__24 = 25;
	public static readonly T__25 = 26;
	public static readonly T__26 = 27;
	public static readonly T__27 = 28;
	public static readonly T__28 = 29;
	public static readonly PROCESSING = 30;
	public static readonly LOSS = 31;
	public static readonly OPTIMIZERS = 32;
	public static readonly DIAGRAMS = 33;
	public static readonly FRAMEWORK = 34;
	public static readonly TYPE = 35;
	public static readonly SCORE_TYPE = 36;
	public static readonly STRINGS = 37;
	public static readonly NUMBER = 38;
	public static readonly DOUBLE = 39;
	public static readonly NAME = 40;
	public static readonly VALID_CSV = 41;
	public static readonly VALID_URL = 42;
	public static readonly NEWLINE = 43;
	public static readonly WS = 44;
	public static readonly COMMENT = 45;
	public static readonly RULE_root = 0;
	public static readonly RULE_description = 1;
	public static readonly RULE_frameworks = 2;
	public static readonly RULE_framework = 3;
	public static readonly RULE_workflow = 4;
	public static readonly RULE_selection = 5;
	public static readonly RULE_source = 6;
	public static readonly RULE_label = 7;
	public static readonly RULE_split = 8;
	public static readonly RULE_split_list = 9;
	public static readonly RULE_preProcessing = 10;
	public static readonly RULE_nan = 11;
	public static readonly RULE_transformation = 12;
	public static readonly RULE_reshape = 13;
	public static readonly RULE_reshape_values = 14;
	public static readonly RULE_normalization = 15;
	public static readonly RULE_normalization_elem = 16;
	public static readonly RULE_data_mining = 17;
	public static readonly RULE_network = 18;
	public static readonly RULE_sequential = 19;
	public static readonly RULE_linear = 20;
	public static readonly RULE_tanh = 21;
	public static readonly RULE_softmax = 22;
	public static readonly RULE_params = 23;
	public static readonly RULE_loss = 24;
	public static readonly RULE_optimizers = 25;
	public static readonly RULE_learningRate = 26;
	public static readonly RULE_nbEpochs = 27;
	public static readonly RULE_batchSize = 28;
	public static readonly RULE_validation = 29;
	public static readonly RULE_diagram = 30;
	public static readonly RULE_score = 31;
	// tslint:disable:no-trailing-whitespace
	public static readonly ruleNames: string[] = [
		"root", "description", "frameworks", "framework", "workflow", "selection", 
		"source", "label", "split", "split_list", "preProcessing", "nan", "transformation", 
		"reshape", "reshape_values", "normalization", "normalization_elem", "data_mining", 
		"network", "sequential", "linear", "tanh", "softmax", "params", "loss", 
		"optimizers", "learningRate", "nbEpochs", "batchSize", "validation", "diagram", 
		"score",
	];

	private static readonly _LITERAL_NAMES: Array<string | undefined> = [
		undefined, "'framework'", "':'", "','", "'selection'", "'source'", "'label_name'", 
		"'is'", "'split'", "'pre_processing'", "'nan'", "'transformation'", "'reshape'", 
		"'['", "']'", "'normalization:'", "'data_mining'", "'network:'", "'sequential:'", 
		"'linear:'", "'tanh'", "'softmax'", "'params:'", "'loss:'", "'optimizers:'", 
		"'learningRate:'", "'nbEpochs:'", "'batchSize:'", "'validation:'", "'diagram:'",
	];
	private static readonly _SYMBOLIC_NAMES: Array<string | undefined> = [
		undefined, undefined, undefined, undefined, undefined, undefined, undefined, 
		undefined, undefined, undefined, undefined, undefined, undefined, undefined, 
		undefined, undefined, undefined, undefined, undefined, undefined, undefined, 
		undefined, undefined, undefined, undefined, undefined, undefined, undefined, 
		undefined, undefined, "PROCESSING", "LOSS", "OPTIMIZERS", "DIAGRAMS", 
		"FRAMEWORK", "TYPE", "SCORE_TYPE", "STRINGS", "NUMBER", "DOUBLE", "NAME", 
		"VALID_CSV", "VALID_URL", "NEWLINE", "WS", "COMMENT",
	];
	public static readonly VOCABULARY: Vocabulary = new VocabularyImpl(NotebookmlParser._LITERAL_NAMES, NotebookmlParser._SYMBOLIC_NAMES, []);

	// @Override
	// @NotNull
	public get vocabulary(): Vocabulary {
		return NotebookmlParser.VOCABULARY;
	}
	// tslint:enable:no-trailing-whitespace

	// @Override
	public get grammarFileName(): string { return "Notebookml.g4"; }

	// @Override
	public get ruleNames(): string[] { return NotebookmlParser.ruleNames; }

	// @Override
	public get serializedATN(): string { return NotebookmlParser._serializedATN; }

	constructor(input: TokenStream) {
		super(input);
		this._interp = new ParserATNSimulator(NotebookmlParser._ATN, this);
	}
	// @RuleVersion(0)
	public root(): RootContext {
		let _localctx: RootContext = new RootContext(this._ctx, this.state);
		this.enterRule(_localctx, 0, NotebookmlParser.RULE_root);
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 64;
			this.description();
			this.state = 65;
			this.frameworks();
			this.state = 66;
			this.workflow();
			this.state = 67;
			this.match(NotebookmlParser.EOF);
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}
	// @RuleVersion(0)
	public description(): DescriptionContext {
		let _localctx: DescriptionContext = new DescriptionContext(this._ctx, this.state);
		this.enterRule(_localctx, 2, NotebookmlParser.RULE_description);
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 69;
			_localctx._detail = this.match(NotebookmlParser.STRINGS);
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}
	// @RuleVersion(0)
	public frameworks(): FrameworksContext {
		let _localctx: FrameworksContext = new FrameworksContext(this._ctx, this.state);
		this.enterRule(_localctx, 4, NotebookmlParser.RULE_frameworks);
		let _la: number;
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 71;
			this.match(NotebookmlParser.T__0);
			this.state = 72;
			this.match(NotebookmlParser.T__1);
			this.state = 76;
			this._errHandler.sync(this);
			_la = this._input.LA(1);
			while (_la === NotebookmlParser.FRAMEWORK) {
				{
				{
				this.state = 73;
				this.framework();
				}
				}
				this.state = 78;
				this._errHandler.sync(this);
				_la = this._input.LA(1);
			}
			this.state = 83;
			this._errHandler.sync(this);
			_la = this._input.LA(1);
			while (_la === NotebookmlParser.T__2) {
				{
				{
				this.state = 79;
				this.match(NotebookmlParser.T__2);
				this.state = 80;
				this.framework();
				}
				}
				this.state = 85;
				this._errHandler.sync(this);
				_la = this._input.LA(1);
			}
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}
	// @RuleVersion(0)
	public framework(): FrameworkContext {
		let _localctx: FrameworkContext = new FrameworkContext(this._ctx, this.state);
		this.enterRule(_localctx, 6, NotebookmlParser.RULE_framework);
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 86;
			_localctx._frameworkType = this.match(NotebookmlParser.FRAMEWORK);
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}
	// @RuleVersion(0)
	public workflow(): WorkflowContext {
		let _localctx: WorkflowContext = new WorkflowContext(this._ctx, this.state);
		this.enterRule(_localctx, 8, NotebookmlParser.RULE_workflow);
		let _la: number;
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 88;
			this.selection();
			{
			this.state = 90;
			this._errHandler.sync(this);
			_la = this._input.LA(1);
			if (_la === NotebookmlParser.T__8) {
				{
				this.state = 89;
				this.preProcessing();
				}
			}

			}
			this.state = 92;
			this.transformation();
			this.state = 93;
			this.data_mining();
			this.state = 94;
			this.validation();
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}
	// @RuleVersion(0)
	public selection(): SelectionContext {
		let _localctx: SelectionContext = new SelectionContext(this._ctx, this.state);
		this.enterRule(_localctx, 10, NotebookmlParser.RULE_selection);
		let _la: number;
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 96;
			this.match(NotebookmlParser.T__3);
			this.state = 97;
			this.match(NotebookmlParser.T__1);
			this.state = 98;
			this.source();
			this.state = 100;
			this._errHandler.sync(this);
			_la = this._input.LA(1);
			if (_la === NotebookmlParser.T__5) {
				{
				this.state = 99;
				this.label();
				}
			}

			this.state = 102;
			this.split();
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}
	// @RuleVersion(0)
	public source(): SourceContext {
		let _localctx: SourceContext = new SourceContext(this._ctx, this.state);
		this.enterRule(_localctx, 12, NotebookmlParser.RULE_source);
		let _la: number;
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 104;
			this.match(NotebookmlParser.T__4);
			this.state = 105;
			this.match(NotebookmlParser.T__1);
			this.state = 106;
			_localctx._sourceId = this._input.LT(1);
			_la = this._input.LA(1);
			if (!(_la === NotebookmlParser.VALID_CSV || _la === NotebookmlParser.VALID_URL)) {
				_localctx._sourceId = this._errHandler.recoverInline(this);
			} else {
				if (this._input.LA(1) === Token.EOF) {
					this.matchedEOF = true;
				}

				this._errHandler.reportMatch(this);
				this.consume();
			}
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}
	// @RuleVersion(0)
	public label(): LabelContext {
		let _localctx: LabelContext = new LabelContext(this._ctx, this.state);
		this.enterRule(_localctx, 14, NotebookmlParser.RULE_label);
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 108;
			this.match(NotebookmlParser.T__5);
			this.state = 109;
			this.match(NotebookmlParser.T__6);
			this.state = 110;
			_localctx._label_name = this.match(NotebookmlParser.NAME);
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}
	// @RuleVersion(0)
	public split(): SplitContext {
		let _localctx: SplitContext = new SplitContext(this._ctx, this.state);
		this.enterRule(_localctx, 16, NotebookmlParser.RULE_split);
		let _la: number;
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 112;
			this.match(NotebookmlParser.T__7);
			this.state = 113;
			this.match(NotebookmlParser.T__1);
			this.state = 115;
			this._errHandler.sync(this);
			_la = this._input.LA(1);
			do {
				{
				{
				this.state = 114;
				this.split_list();
				}
				}
				this.state = 117;
				this._errHandler.sync(this);
				_la = this._input.LA(1);
			} while (_la === NotebookmlParser.TYPE);
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}
	// @RuleVersion(0)
	public split_list(): Split_listContext {
		let _localctx: Split_listContext = new Split_listContext(this._ctx, this.state);
		this.enterRule(_localctx, 18, NotebookmlParser.RULE_split_list);
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 119;
			_localctx._type = this.match(NotebookmlParser.TYPE);
			this.state = 120;
			this.match(NotebookmlParser.T__6);
			this.state = 121;
			_localctx._percentage = this.match(NotebookmlParser.NUMBER);
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}
	// @RuleVersion(0)
	public preProcessing(): PreProcessingContext {
		let _localctx: PreProcessingContext = new PreProcessingContext(this._ctx, this.state);
		this.enterRule(_localctx, 20, NotebookmlParser.RULE_preProcessing);
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 123;
			this.match(NotebookmlParser.T__8);
			this.state = 124;
			this.match(NotebookmlParser.T__1);
			this.state = 125;
			this.nan();
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}
	// @RuleVersion(0)
	public nan(): NanContext {
		let _localctx: NanContext = new NanContext(this._ctx, this.state);
		this.enterRule(_localctx, 22, NotebookmlParser.RULE_nan);
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 127;
			this.match(NotebookmlParser.T__9);
			{
			this.state = 128;
			_localctx._nan_processing = this.match(NotebookmlParser.PROCESSING);
			}
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}
	// @RuleVersion(0)
	public transformation(): TransformationContext {
		let _localctx: TransformationContext = new TransformationContext(this._ctx, this.state);
		this.enterRule(_localctx, 24, NotebookmlParser.RULE_transformation);
		let _la: number;
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 130;
			this.match(NotebookmlParser.T__10);
			this.state = 131;
			this.match(NotebookmlParser.T__1);
			this.state = 136;
			this._errHandler.sync(this);
			_la = this._input.LA(1);
			while (_la === NotebookmlParser.T__11 || _la === NotebookmlParser.T__14) {
				{
				this.state = 134;
				this._errHandler.sync(this);
				switch (this._input.LA(1)) {
				case NotebookmlParser.T__11:
					{
					this.state = 132;
					this.reshape();
					}
					break;
				case NotebookmlParser.T__14:
					{
					this.state = 133;
					this.normalization();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				this.state = 138;
				this._errHandler.sync(this);
				_la = this._input.LA(1);
			}
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}
	// @RuleVersion(0)
	public reshape(): ReshapeContext {
		let _localctx: ReshapeContext = new ReshapeContext(this._ctx, this.state);
		this.enterRule(_localctx, 26, NotebookmlParser.RULE_reshape);
		let _la: number;
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 139;
			this.match(NotebookmlParser.T__11);
			this.state = 140;
			_localctx._type = this.match(NotebookmlParser.TYPE);
			this.state = 141;
			this.match(NotebookmlParser.T__12);
			this.state = 145;
			this._errHandler.sync(this);
			_la = this._input.LA(1);
			while (_la === NotebookmlParser.NUMBER) {
				{
				{
				this.state = 142;
				this.reshape_values();
				}
				}
				this.state = 147;
				this._errHandler.sync(this);
				_la = this._input.LA(1);
			}
			this.state = 152;
			this._errHandler.sync(this);
			_la = this._input.LA(1);
			while (_la === NotebookmlParser.T__2) {
				{
				{
				this.state = 148;
				this.match(NotebookmlParser.T__2);
				this.state = 149;
				this.reshape_values();
				}
				}
				this.state = 154;
				this._errHandler.sync(this);
				_la = this._input.LA(1);
			}
			this.state = 155;
			this.match(NotebookmlParser.T__13);
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}
	// @RuleVersion(0)
	public reshape_values(): Reshape_valuesContext {
		let _localctx: Reshape_valuesContext = new Reshape_valuesContext(this._ctx, this.state);
		this.enterRule(_localctx, 28, NotebookmlParser.RULE_reshape_values);
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 157;
			_localctx._reshape_value = this.match(NotebookmlParser.NUMBER);
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}
	// @RuleVersion(0)
	public normalization(): NormalizationContext {
		let _localctx: NormalizationContext = new NormalizationContext(this._ctx, this.state);
		this.enterRule(_localctx, 30, NotebookmlParser.RULE_normalization);
		let _la: number;
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 159;
			this.match(NotebookmlParser.T__14);
			this.state = 161;
			this._errHandler.sync(this);
			_la = this._input.LA(1);
			do {
				{
				{
				this.state = 160;
				this.normalization_elem();
				}
				}
				this.state = 163;
				this._errHandler.sync(this);
				_la = this._input.LA(1);
			} while (_la === NotebookmlParser.TYPE);
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}
	// @RuleVersion(0)
	public normalization_elem(): Normalization_elemContext {
		let _localctx: Normalization_elemContext = new Normalization_elemContext(this._ctx, this.state);
		this.enterRule(_localctx, 32, NotebookmlParser.RULE_normalization_elem);
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 165;
			_localctx._type = this.match(NotebookmlParser.TYPE);
			this.state = 166;
			_localctx._size = this.match(NotebookmlParser.NUMBER);
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}
	// @RuleVersion(0)
	public data_mining(): Data_miningContext {
		let _localctx: Data_miningContext = new Data_miningContext(this._ctx, this.state);
		this.enterRule(_localctx, 34, NotebookmlParser.RULE_data_mining);
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 168;
			this.match(NotebookmlParser.T__15);
			this.state = 169;
			this.match(NotebookmlParser.T__1);
			this.state = 170;
			this.network();
			this.state = 171;
			this.params();
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}
	// @RuleVersion(0)
	public network(): NetworkContext {
		let _localctx: NetworkContext = new NetworkContext(this._ctx, this.state);
		this.enterRule(_localctx, 36, NotebookmlParser.RULE_network);
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 173;
			this.match(NotebookmlParser.T__16);
			this.state = 174;
			this.sequential();
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}
	// @RuleVersion(0)
	public sequential(): SequentialContext {
		let _localctx: SequentialContext = new SequentialContext(this._ctx, this.state);
		this.enterRule(_localctx, 38, NotebookmlParser.RULE_sequential);
		let _la: number;
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 176;
			this.match(NotebookmlParser.T__17);
			this.state = 180;
			this._errHandler.sync(this);
			_la = this._input.LA(1);
			do {
				{
				this.state = 180;
				this._errHandler.sync(this);
				switch (this._input.LA(1)) {
				case NotebookmlParser.T__18:
					{
					this.state = 177;
					this.linear();
					}
					break;
				case NotebookmlParser.T__19:
					{
					this.state = 178;
					this.tanh();
					}
					break;
				case NotebookmlParser.T__20:
					{
					this.state = 179;
					this.softmax();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				this.state = 182;
				this._errHandler.sync(this);
				_la = this._input.LA(1);
			} while ((((_la) & ~0x1F) === 0 && ((1 << _la) & ((1 << NotebookmlParser.T__18) | (1 << NotebookmlParser.T__19) | (1 << NotebookmlParser.T__20))) !== 0));
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}
	// @RuleVersion(0)
	public linear(): LinearContext {
		let _localctx: LinearContext = new LinearContext(this._ctx, this.state);
		this.enterRule(_localctx, 40, NotebookmlParser.RULE_linear);
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 184;
			this.match(NotebookmlParser.T__18);
			this.state = 185;
			_localctx._linear_in = this.match(NotebookmlParser.NUMBER);
			this.state = 186;
			_localctx._linear_out = this.match(NotebookmlParser.NUMBER);
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}
	// @RuleVersion(0)
	public tanh(): TanhContext {
		let _localctx: TanhContext = new TanhContext(this._ctx, this.state);
		this.enterRule(_localctx, 42, NotebookmlParser.RULE_tanh);
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 188;
			this.match(NotebookmlParser.T__19);
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}
	// @RuleVersion(0)
	public softmax(): SoftmaxContext {
		let _localctx: SoftmaxContext = new SoftmaxContext(this._ctx, this.state);
		this.enterRule(_localctx, 44, NotebookmlParser.RULE_softmax);
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 190;
			this.match(NotebookmlParser.T__20);
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}
	// @RuleVersion(0)
	public params(): ParamsContext {
		let _localctx: ParamsContext = new ParamsContext(this._ctx, this.state);
		this.enterRule(_localctx, 46, NotebookmlParser.RULE_params);
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 192;
			this.match(NotebookmlParser.T__21);
			this.state = 193;
			this.loss();
			this.state = 194;
			this.optimizers();
			this.state = 195;
			this.learningRate();
			this.state = 196;
			this.nbEpochs();
			this.state = 197;
			this.batchSize();
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}
	// @RuleVersion(0)
	public loss(): LossContext {
		let _localctx: LossContext = new LossContext(this._ctx, this.state);
		this.enterRule(_localctx, 48, NotebookmlParser.RULE_loss);
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 199;
			this.match(NotebookmlParser.T__22);
			this.state = 200;
			_localctx._loss_type = this.match(NotebookmlParser.LOSS);
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}
	// @RuleVersion(0)
	public optimizers(): OptimizersContext {
		let _localctx: OptimizersContext = new OptimizersContext(this._ctx, this.state);
		this.enterRule(_localctx, 50, NotebookmlParser.RULE_optimizers);
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 202;
			this.match(NotebookmlParser.T__23);
			this.state = 203;
			_localctx._optimizers_type = this.match(NotebookmlParser.OPTIMIZERS);
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}
	// @RuleVersion(0)
	public learningRate(): LearningRateContext {
		let _localctx: LearningRateContext = new LearningRateContext(this._ctx, this.state);
		this.enterRule(_localctx, 52, NotebookmlParser.RULE_learningRate);
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 205;
			this.match(NotebookmlParser.T__24);
			this.state = 206;
			_localctx._learningRate_nb = this.match(NotebookmlParser.DOUBLE);
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}
	// @RuleVersion(0)
	public nbEpochs(): NbEpochsContext {
		let _localctx: NbEpochsContext = new NbEpochsContext(this._ctx, this.state);
		this.enterRule(_localctx, 54, NotebookmlParser.RULE_nbEpochs);
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 208;
			this.match(NotebookmlParser.T__25);
			this.state = 209;
			_localctx._nbEpochs_nb = this.match(NotebookmlParser.NUMBER);
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}
	// @RuleVersion(0)
	public batchSize(): BatchSizeContext {
		let _localctx: BatchSizeContext = new BatchSizeContext(this._ctx, this.state);
		this.enterRule(_localctx, 56, NotebookmlParser.RULE_batchSize);
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 211;
			this.match(NotebookmlParser.T__26);
			this.state = 212;
			_localctx._batchSize_nb = this.match(NotebookmlParser.NUMBER);
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}
	// @RuleVersion(0)
	public validation(): ValidationContext {
		let _localctx: ValidationContext = new ValidationContext(this._ctx, this.state);
		this.enterRule(_localctx, 58, NotebookmlParser.RULE_validation);
		let _la: number;
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 214;
			this.match(NotebookmlParser.T__27);
			this.state = 217;
			this._errHandler.sync(this);
			_la = this._input.LA(1);
			do {
				{
				this.state = 217;
				this._errHandler.sync(this);
				switch (this._input.LA(1)) {
				case NotebookmlParser.T__28:
					{
					this.state = 215;
					this.diagram();
					}
					break;
				case NotebookmlParser.SCORE_TYPE:
					{
					this.state = 216;
					this.score();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				this.state = 219;
				this._errHandler.sync(this);
				_la = this._input.LA(1);
			} while (_la === NotebookmlParser.T__28 || _la === NotebookmlParser.SCORE_TYPE);
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}
	// @RuleVersion(0)
	public diagram(): DiagramContext {
		let _localctx: DiagramContext = new DiagramContext(this._ctx, this.state);
		this.enterRule(_localctx, 60, NotebookmlParser.RULE_diagram);
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 221;
			this.match(NotebookmlParser.T__28);
			this.state = 222;
			_localctx._diagram_name = this.match(NotebookmlParser.DIAGRAMS);
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}
	// @RuleVersion(0)
	public score(): ScoreContext {
		let _localctx: ScoreContext = new ScoreContext(this._ctx, this.state);
		this.enterRule(_localctx, 62, NotebookmlParser.RULE_score);
		try {
			this.enterOuterAlt(_localctx, 1);
			{
			this.state = 224;
			_localctx._score_type = this.match(NotebookmlParser.SCORE_TYPE);
			}
		}
		catch (re) {
			if (re instanceof RecognitionException) {
				_localctx.exception = re;
				this._errHandler.reportError(this, re);
				this._errHandler.recover(this, re);
			} else {
				throw re;
			}
		}
		finally {
			this.exitRule();
		}
		return _localctx;
	}

	public static readonly _serializedATN: string =
		"\x03\uC91D\uCABA\u058D\uAFBA\u4F53\u0607\uEA8B\uC241\x03/\xE5\x04\x02" +
		"\t\x02\x04\x03\t\x03\x04\x04\t\x04\x04\x05\t\x05\x04\x06\t\x06\x04\x07" +
		"\t\x07\x04\b\t\b\x04\t\t\t\x04\n\t\n\x04\v\t\v\x04\f\t\f\x04\r\t\r\x04" +
		"\x0E\t\x0E\x04\x0F\t\x0F\x04\x10\t\x10\x04\x11\t\x11\x04\x12\t\x12\x04" +
		"\x13\t\x13\x04\x14\t\x14\x04\x15\t\x15\x04\x16\t\x16\x04\x17\t\x17\x04" +
		"\x18\t\x18\x04\x19\t\x19\x04\x1A\t\x1A\x04\x1B\t\x1B\x04\x1C\t\x1C\x04" +
		"\x1D\t\x1D\x04\x1E\t\x1E\x04\x1F\t\x1F\x04 \t \x04!\t!\x03\x02\x03\x02" +
		"\x03\x02\x03\x02\x03\x02\x03\x03\x03\x03\x03\x04\x03\x04\x03\x04\x07\x04" +
		"M\n\x04\f\x04\x0E\x04P\v\x04\x03\x04\x03\x04\x07\x04T\n\x04\f\x04\x0E" +
		"\x04W\v\x04\x03\x05\x03\x05\x03\x06\x03\x06\x05\x06]\n\x06\x03\x06\x03" +
		"\x06\x03\x06\x03\x06\x03\x07\x03\x07\x03\x07\x03\x07\x05\x07g\n\x07\x03" +
		"\x07\x03\x07\x03\b\x03\b\x03\b\x03\b\x03\t\x03\t\x03\t\x03\t\x03\n\x03" +
		"\n\x03\n\x06\nv\n\n\r\n\x0E\nw\x03\v\x03\v\x03\v\x03\v\x03\f\x03\f\x03" +
		"\f\x03\f\x03\r\x03\r\x03\r\x03\x0E\x03\x0E\x03\x0E\x03\x0E\x07\x0E\x89" +
		"\n\x0E\f\x0E\x0E\x0E\x8C\v\x0E\x03\x0F\x03\x0F\x03\x0F\x03\x0F\x07\x0F" +
		"\x92\n\x0F\f\x0F\x0E\x0F\x95\v\x0F\x03\x0F\x03\x0F\x07\x0F\x99\n\x0F\f" +
		"\x0F\x0E\x0F\x9C\v\x0F\x03\x0F\x03\x0F\x03\x10\x03\x10\x03\x11\x03\x11" +
		"\x06\x11\xA4\n\x11\r\x11\x0E\x11\xA5\x03\x12\x03\x12\x03\x12\x03\x13\x03" +
		"\x13\x03\x13\x03\x13\x03\x13\x03\x14\x03\x14\x03\x14\x03\x15\x03\x15\x03" +
		"\x15\x03\x15\x06\x15\xB7\n\x15\r\x15\x0E\x15\xB8\x03\x16\x03\x16\x03\x16" +
		"\x03\x16\x03\x17\x03\x17\x03\x18\x03\x18\x03\x19\x03\x19\x03\x19\x03\x19" +
		"\x03\x19\x03\x19\x03\x19\x03\x1A\x03\x1A\x03\x1A\x03\x1B\x03\x1B\x03\x1B" +
		"\x03\x1C\x03\x1C\x03\x1C\x03\x1D\x03\x1D\x03\x1D\x03\x1E\x03\x1E\x03\x1E" +
		"\x03\x1F\x03\x1F\x03\x1F\x06\x1F\xDC\n\x1F\r\x1F\x0E\x1F\xDD\x03 \x03" +
		" \x03 \x03!\x03!\x03!\x02\x02\x02\"\x02\x02\x04\x02\x06\x02\b\x02\n\x02" +
		"\f\x02\x0E\x02\x10\x02\x12\x02\x14\x02\x16\x02\x18\x02\x1A\x02\x1C\x02" +
		"\x1E\x02 \x02\"\x02$\x02&\x02(\x02*\x02,\x02.\x020\x022\x024\x026\x02" +
		"8\x02:\x02<\x02>\x02@\x02\x02\x03\x03\x02+,\x02\xD3\x02B\x03\x02\x02\x02" +
		"\x04G\x03\x02\x02\x02\x06I\x03\x02\x02\x02\bX\x03\x02\x02\x02\nZ\x03\x02" +
		"\x02\x02\fb\x03\x02\x02\x02\x0Ej\x03\x02\x02\x02\x10n\x03\x02\x02\x02" +
		"\x12r\x03\x02\x02\x02\x14y\x03\x02\x02\x02\x16}\x03\x02\x02\x02\x18\x81" +
		"\x03\x02\x02\x02\x1A\x84\x03\x02\x02\x02\x1C\x8D\x03\x02\x02\x02\x1E\x9F" +
		"\x03\x02\x02\x02 \xA1\x03\x02\x02\x02\"\xA7\x03\x02\x02\x02$\xAA\x03\x02" +
		"\x02\x02&\xAF\x03\x02\x02\x02(\xB2\x03\x02\x02\x02*\xBA\x03\x02\x02\x02" +
		",\xBE\x03\x02\x02\x02.\xC0\x03\x02\x02\x020\xC2\x03\x02\x02\x022\xC9\x03" +
		"\x02\x02\x024\xCC\x03\x02\x02\x026\xCF\x03\x02\x02\x028\xD2\x03\x02\x02" +
		"\x02:\xD5\x03\x02\x02\x02<\xD8\x03\x02\x02\x02>\xDF\x03\x02\x02\x02@\xE2" +
		"\x03\x02\x02\x02BC\x05\x04\x03\x02CD\x05\x06\x04\x02DE\x05\n\x06\x02E" +
		"F\x07\x02\x02\x03F\x03\x03\x02\x02\x02GH\x07\'\x02\x02H\x05\x03\x02\x02" +
		"\x02IJ\x07\x03\x02\x02JN\x07\x04\x02\x02KM\x05\b\x05\x02LK\x03\x02\x02" +
		"\x02MP\x03\x02\x02\x02NL\x03\x02\x02\x02NO\x03\x02\x02\x02OU\x03\x02\x02" +
		"\x02PN\x03\x02\x02\x02QR\x07\x05\x02\x02RT\x05\b\x05\x02SQ\x03\x02\x02" +
		"\x02TW\x03\x02\x02\x02US\x03\x02\x02\x02UV\x03\x02\x02\x02V\x07\x03\x02" +
		"\x02\x02WU\x03\x02\x02\x02XY\x07$\x02\x02Y\t\x03\x02\x02\x02Z\\\x05\f" +
		"\x07\x02[]\x05\x16\f\x02\\[\x03\x02\x02\x02\\]\x03\x02\x02\x02]^\x03\x02" +
		"\x02\x02^_\x05\x1A\x0E\x02_`\x05$\x13\x02`a\x05<\x1F\x02a\v\x03\x02\x02" +
		"\x02bc\x07\x06\x02\x02cd\x07\x04\x02\x02df\x05\x0E\b\x02eg\x05\x10\t\x02" +
		"fe\x03\x02\x02\x02fg\x03\x02\x02\x02gh\x03\x02\x02\x02hi\x05\x12\n\x02" +
		"i\r\x03\x02\x02\x02jk\x07\x07\x02\x02kl\x07\x04\x02\x02lm\t\x02\x02\x02" +
		"m\x0F\x03\x02\x02\x02no\x07\b\x02\x02op\x07\t\x02\x02pq\x07*\x02\x02q" +
		"\x11\x03\x02\x02\x02rs\x07\n\x02\x02su\x07\x04\x02\x02tv\x05\x14\v\x02" +
		"ut\x03\x02\x02\x02vw\x03\x02\x02\x02wu\x03\x02\x02\x02wx\x03\x02\x02\x02" +
		"x\x13\x03\x02\x02\x02yz\x07%\x02\x02z{\x07\t\x02\x02{|\x07(\x02\x02|\x15" +
		"\x03\x02\x02\x02}~\x07\v\x02\x02~\x7F\x07\x04\x02\x02\x7F\x80\x05\x18" +
		"\r\x02\x80\x17\x03\x02\x02\x02\x81\x82\x07\f\x02\x02\x82\x83\x07 \x02" +
		"\x02\x83\x19\x03\x02\x02\x02\x84\x85\x07\r\x02\x02\x85\x8A\x07\x04\x02" +
		"\x02\x86\x89\x05\x1C\x0F\x02\x87\x89\x05 \x11\x02\x88\x86\x03\x02\x02" +
		"\x02\x88\x87\x03\x02\x02\x02\x89\x8C\x03\x02\x02\x02\x8A\x88\x03\x02\x02" +
		"\x02\x8A\x8B\x03\x02\x02\x02\x8B\x1B\x03\x02\x02\x02\x8C\x8A\x03\x02\x02" +
		"\x02\x8D\x8E\x07\x0E\x02\x02\x8E\x8F\x07%\x02\x02\x8F\x93\x07\x0F\x02" +
		"\x02\x90\x92\x05\x1E\x10\x02\x91\x90\x03\x02\x02\x02\x92\x95\x03\x02\x02" +
		"\x02\x93\x91\x03\x02\x02\x02\x93\x94\x03\x02\x02\x02\x94\x9A\x03\x02\x02" +
		"\x02\x95\x93\x03\x02\x02\x02\x96\x97\x07\x05\x02\x02\x97\x99\x05\x1E\x10" +
		"\x02\x98\x96\x03\x02\x02\x02\x99\x9C\x03\x02\x02\x02\x9A\x98\x03\x02\x02" +
		"\x02\x9A\x9B\x03\x02\x02\x02\x9B\x9D\x03\x02\x02\x02\x9C\x9A\x03\x02\x02" +
		"\x02\x9D\x9E\x07\x10\x02\x02\x9E\x1D\x03\x02\x02\x02\x9F\xA0\x07(\x02" +
		"\x02\xA0\x1F\x03\x02\x02\x02\xA1\xA3\x07\x11\x02\x02\xA2\xA4\x05\"\x12" +
		"\x02\xA3\xA2\x03\x02\x02\x02\xA4\xA5\x03\x02\x02\x02\xA5\xA3\x03\x02\x02" +
		"\x02\xA5\xA6\x03\x02\x02\x02\xA6!\x03\x02\x02\x02\xA7\xA8\x07%\x02\x02" +
		"\xA8\xA9\x07(\x02\x02\xA9#\x03\x02\x02\x02\xAA\xAB\x07\x12\x02\x02\xAB" +
		"\xAC\x07\x04\x02\x02\xAC\xAD\x05&\x14\x02\xAD\xAE\x050\x19\x02\xAE%\x03" +
		"\x02\x02\x02\xAF\xB0\x07\x13\x02\x02\xB0\xB1\x05(\x15\x02\xB1\'\x03\x02" +
		"\x02\x02\xB2\xB6\x07\x14\x02\x02\xB3\xB7\x05*\x16\x02\xB4\xB7\x05,\x17" +
		"\x02\xB5\xB7\x05.\x18\x02\xB6\xB3\x03\x02\x02\x02\xB6\xB4\x03\x02\x02" +
		"\x02\xB6\xB5\x03\x02\x02\x02\xB7\xB8\x03\x02\x02\x02\xB8\xB6\x03\x02\x02" +
		"\x02\xB8\xB9\x03\x02\x02\x02\xB9)\x03\x02\x02\x02\xBA\xBB\x07\x15\x02" +
		"\x02\xBB\xBC\x07(\x02\x02\xBC\xBD\x07(\x02\x02\xBD+\x03\x02\x02\x02\xBE" +
		"\xBF\x07\x16\x02\x02\xBF-\x03\x02\x02\x02\xC0\xC1\x07\x17\x02\x02\xC1" +
		"/\x03\x02\x02\x02\xC2\xC3\x07\x18\x02\x02\xC3\xC4\x052\x1A\x02\xC4\xC5" +
		"\x054\x1B\x02\xC5\xC6\x056\x1C\x02\xC6\xC7\x058\x1D\x02\xC7\xC8\x05:\x1E" +
		"\x02\xC81\x03\x02\x02\x02\xC9\xCA\x07\x19\x02\x02\xCA\xCB\x07!\x02\x02" +
		"\xCB3\x03\x02\x02\x02\xCC\xCD\x07\x1A\x02\x02\xCD\xCE\x07\"\x02\x02\xCE" +
		"5\x03\x02\x02\x02\xCF\xD0\x07\x1B\x02\x02\xD0\xD1\x07)\x02\x02\xD17\x03" +
		"\x02\x02\x02\xD2\xD3\x07\x1C\x02\x02\xD3\xD4\x07(\x02\x02\xD49\x03\x02" +
		"\x02\x02\xD5\xD6\x07\x1D\x02\x02\xD6\xD7\x07(\x02\x02\xD7;\x03\x02\x02" +
		"\x02\xD8\xDB\x07\x1E\x02\x02\xD9\xDC\x05> \x02\xDA\xDC\x05@!\x02\xDB\xD9" +
		"\x03\x02\x02\x02\xDB\xDA\x03\x02\x02\x02\xDC\xDD\x03\x02\x02\x02\xDD\xDB" +
		"\x03\x02\x02\x02\xDD\xDE\x03\x02\x02\x02\xDE=\x03\x02\x02\x02\xDF\xE0" +
		"\x07\x1F\x02\x02\xE0\xE1\x07#\x02\x02\xE1?\x03\x02\x02\x02\xE2\xE3\x07" +
		"&\x02\x02\xE3A\x03\x02\x02\x02\x10NU\\fw\x88\x8A\x93\x9A\xA5\xB6\xB8\xDB" +
		"\xDD";
	public static __ATN: ATN;
	public static get _ATN(): ATN {
		if (!NotebookmlParser.__ATN) {
			NotebookmlParser.__ATN = new ATNDeserializer().deserialize(Utils.toCharArray(NotebookmlParser._serializedATN));
		}

		return NotebookmlParser.__ATN;
	}

}

export class RootContext extends ParserRuleContext {
	public description(): DescriptionContext {
		return this.getRuleContext(0, DescriptionContext);
	}
	public frameworks(): FrameworksContext {
		return this.getRuleContext(0, FrameworksContext);
	}
	public workflow(): WorkflowContext {
		return this.getRuleContext(0, WorkflowContext);
	}
	public EOF(): TerminalNode { return this.getToken(NotebookmlParser.EOF, 0); }
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return NotebookmlParser.RULE_root; }
	// @Override
	public enterRule(listener: NotebookmlListener): void {
		if (listener.enterRoot) {
			listener.enterRoot(this);
		}
	}
	// @Override
	public exitRule(listener: NotebookmlListener): void {
		if (listener.exitRoot) {
			listener.exitRoot(this);
		}
	}
	// @Override
	public accept<Result>(visitor: NotebookmlVisitor<Result>): Result {
		if (visitor.visitRoot) {
			return visitor.visitRoot(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


export class DescriptionContext extends ParserRuleContext {
	public _detail: Token;
	public STRINGS(): TerminalNode { return this.getToken(NotebookmlParser.STRINGS, 0); }
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return NotebookmlParser.RULE_description; }
	// @Override
	public enterRule(listener: NotebookmlListener): void {
		if (listener.enterDescription) {
			listener.enterDescription(this);
		}
	}
	// @Override
	public exitRule(listener: NotebookmlListener): void {
		if (listener.exitDescription) {
			listener.exitDescription(this);
		}
	}
	// @Override
	public accept<Result>(visitor: NotebookmlVisitor<Result>): Result {
		if (visitor.visitDescription) {
			return visitor.visitDescription(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


export class FrameworksContext extends ParserRuleContext {
	public framework(): FrameworkContext[];
	public framework(i: number): FrameworkContext;
	public framework(i?: number): FrameworkContext | FrameworkContext[] {
		if (i === undefined) {
			return this.getRuleContexts(FrameworkContext);
		} else {
			return this.getRuleContext(i, FrameworkContext);
		}
	}
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return NotebookmlParser.RULE_frameworks; }
	// @Override
	public enterRule(listener: NotebookmlListener): void {
		if (listener.enterFrameworks) {
			listener.enterFrameworks(this);
		}
	}
	// @Override
	public exitRule(listener: NotebookmlListener): void {
		if (listener.exitFrameworks) {
			listener.exitFrameworks(this);
		}
	}
	// @Override
	public accept<Result>(visitor: NotebookmlVisitor<Result>): Result {
		if (visitor.visitFrameworks) {
			return visitor.visitFrameworks(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


export class FrameworkContext extends ParserRuleContext {
	public _frameworkType: Token;
	public FRAMEWORK(): TerminalNode { return this.getToken(NotebookmlParser.FRAMEWORK, 0); }
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return NotebookmlParser.RULE_framework; }
	// @Override
	public enterRule(listener: NotebookmlListener): void {
		if (listener.enterFramework) {
			listener.enterFramework(this);
		}
	}
	// @Override
	public exitRule(listener: NotebookmlListener): void {
		if (listener.exitFramework) {
			listener.exitFramework(this);
		}
	}
	// @Override
	public accept<Result>(visitor: NotebookmlVisitor<Result>): Result {
		if (visitor.visitFramework) {
			return visitor.visitFramework(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


export class WorkflowContext extends ParserRuleContext {
	public selection(): SelectionContext {
		return this.getRuleContext(0, SelectionContext);
	}
	public transformation(): TransformationContext {
		return this.getRuleContext(0, TransformationContext);
	}
	public data_mining(): Data_miningContext {
		return this.getRuleContext(0, Data_miningContext);
	}
	public validation(): ValidationContext {
		return this.getRuleContext(0, ValidationContext);
	}
	public preProcessing(): PreProcessingContext | undefined {
		return this.tryGetRuleContext(0, PreProcessingContext);
	}
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return NotebookmlParser.RULE_workflow; }
	// @Override
	public enterRule(listener: NotebookmlListener): void {
		if (listener.enterWorkflow) {
			listener.enterWorkflow(this);
		}
	}
	// @Override
	public exitRule(listener: NotebookmlListener): void {
		if (listener.exitWorkflow) {
			listener.exitWorkflow(this);
		}
	}
	// @Override
	public accept<Result>(visitor: NotebookmlVisitor<Result>): Result {
		if (visitor.visitWorkflow) {
			return visitor.visitWorkflow(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


export class SelectionContext extends ParserRuleContext {
	public source(): SourceContext {
		return this.getRuleContext(0, SourceContext);
	}
	public split(): SplitContext {
		return this.getRuleContext(0, SplitContext);
	}
	public label(): LabelContext | undefined {
		return this.tryGetRuleContext(0, LabelContext);
	}
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return NotebookmlParser.RULE_selection; }
	// @Override
	public enterRule(listener: NotebookmlListener): void {
		if (listener.enterSelection) {
			listener.enterSelection(this);
		}
	}
	// @Override
	public exitRule(listener: NotebookmlListener): void {
		if (listener.exitSelection) {
			listener.exitSelection(this);
		}
	}
	// @Override
	public accept<Result>(visitor: NotebookmlVisitor<Result>): Result {
		if (visitor.visitSelection) {
			return visitor.visitSelection(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


export class SourceContext extends ParserRuleContext {
	public _sourceId: Token;
	public VALID_CSV(): TerminalNode | undefined { return this.tryGetToken(NotebookmlParser.VALID_CSV, 0); }
	public VALID_URL(): TerminalNode | undefined { return this.tryGetToken(NotebookmlParser.VALID_URL, 0); }
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return NotebookmlParser.RULE_source; }
	// @Override
	public enterRule(listener: NotebookmlListener): void {
		if (listener.enterSource) {
			listener.enterSource(this);
		}
	}
	// @Override
	public exitRule(listener: NotebookmlListener): void {
		if (listener.exitSource) {
			listener.exitSource(this);
		}
	}
	// @Override
	public accept<Result>(visitor: NotebookmlVisitor<Result>): Result {
		if (visitor.visitSource) {
			return visitor.visitSource(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


export class LabelContext extends ParserRuleContext {
	public _label_name: Token;
	public NAME(): TerminalNode { return this.getToken(NotebookmlParser.NAME, 0); }
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return NotebookmlParser.RULE_label; }
	// @Override
	public enterRule(listener: NotebookmlListener): void {
		if (listener.enterLabel) {
			listener.enterLabel(this);
		}
	}
	// @Override
	public exitRule(listener: NotebookmlListener): void {
		if (listener.exitLabel) {
			listener.exitLabel(this);
		}
	}
	// @Override
	public accept<Result>(visitor: NotebookmlVisitor<Result>): Result {
		if (visitor.visitLabel) {
			return visitor.visitLabel(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


export class SplitContext extends ParserRuleContext {
	public split_list(): Split_listContext[];
	public split_list(i: number): Split_listContext;
	public split_list(i?: number): Split_listContext | Split_listContext[] {
		if (i === undefined) {
			return this.getRuleContexts(Split_listContext);
		} else {
			return this.getRuleContext(i, Split_listContext);
		}
	}
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return NotebookmlParser.RULE_split; }
	// @Override
	public enterRule(listener: NotebookmlListener): void {
		if (listener.enterSplit) {
			listener.enterSplit(this);
		}
	}
	// @Override
	public exitRule(listener: NotebookmlListener): void {
		if (listener.exitSplit) {
			listener.exitSplit(this);
		}
	}
	// @Override
	public accept<Result>(visitor: NotebookmlVisitor<Result>): Result {
		if (visitor.visitSplit) {
			return visitor.visitSplit(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


export class Split_listContext extends ParserRuleContext {
	public _type: Token;
	public _percentage: Token;
	public TYPE(): TerminalNode { return this.getToken(NotebookmlParser.TYPE, 0); }
	public NUMBER(): TerminalNode { return this.getToken(NotebookmlParser.NUMBER, 0); }
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return NotebookmlParser.RULE_split_list; }
	// @Override
	public enterRule(listener: NotebookmlListener): void {
		if (listener.enterSplit_list) {
			listener.enterSplit_list(this);
		}
	}
	// @Override
	public exitRule(listener: NotebookmlListener): void {
		if (listener.exitSplit_list) {
			listener.exitSplit_list(this);
		}
	}
	// @Override
	public accept<Result>(visitor: NotebookmlVisitor<Result>): Result {
		if (visitor.visitSplit_list) {
			return visitor.visitSplit_list(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


export class PreProcessingContext extends ParserRuleContext {
	public nan(): NanContext {
		return this.getRuleContext(0, NanContext);
	}
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return NotebookmlParser.RULE_preProcessing; }
	// @Override
	public enterRule(listener: NotebookmlListener): void {
		if (listener.enterPreProcessing) {
			listener.enterPreProcessing(this);
		}
	}
	// @Override
	public exitRule(listener: NotebookmlListener): void {
		if (listener.exitPreProcessing) {
			listener.exitPreProcessing(this);
		}
	}
	// @Override
	public accept<Result>(visitor: NotebookmlVisitor<Result>): Result {
		if (visitor.visitPreProcessing) {
			return visitor.visitPreProcessing(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


export class NanContext extends ParserRuleContext {
	public _nan_processing: Token;
	public PROCESSING(): TerminalNode | undefined { return this.tryGetToken(NotebookmlParser.PROCESSING, 0); }
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return NotebookmlParser.RULE_nan; }
	// @Override
	public enterRule(listener: NotebookmlListener): void {
		if (listener.enterNan) {
			listener.enterNan(this);
		}
	}
	// @Override
	public exitRule(listener: NotebookmlListener): void {
		if (listener.exitNan) {
			listener.exitNan(this);
		}
	}
	// @Override
	public accept<Result>(visitor: NotebookmlVisitor<Result>): Result {
		if (visitor.visitNan) {
			return visitor.visitNan(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


export class TransformationContext extends ParserRuleContext {
	public reshape(): ReshapeContext[];
	public reshape(i: number): ReshapeContext;
	public reshape(i?: number): ReshapeContext | ReshapeContext[] {
		if (i === undefined) {
			return this.getRuleContexts(ReshapeContext);
		} else {
			return this.getRuleContext(i, ReshapeContext);
		}
	}
	public normalization(): NormalizationContext[];
	public normalization(i: number): NormalizationContext;
	public normalization(i?: number): NormalizationContext | NormalizationContext[] {
		if (i === undefined) {
			return this.getRuleContexts(NormalizationContext);
		} else {
			return this.getRuleContext(i, NormalizationContext);
		}
	}
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return NotebookmlParser.RULE_transformation; }
	// @Override
	public enterRule(listener: NotebookmlListener): void {
		if (listener.enterTransformation) {
			listener.enterTransformation(this);
		}
	}
	// @Override
	public exitRule(listener: NotebookmlListener): void {
		if (listener.exitTransformation) {
			listener.exitTransformation(this);
		}
	}
	// @Override
	public accept<Result>(visitor: NotebookmlVisitor<Result>): Result {
		if (visitor.visitTransformation) {
			return visitor.visitTransformation(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


export class ReshapeContext extends ParserRuleContext {
	public _type: Token;
	public TYPE(): TerminalNode { return this.getToken(NotebookmlParser.TYPE, 0); }
	public reshape_values(): Reshape_valuesContext[];
	public reshape_values(i: number): Reshape_valuesContext;
	public reshape_values(i?: number): Reshape_valuesContext | Reshape_valuesContext[] {
		if (i === undefined) {
			return this.getRuleContexts(Reshape_valuesContext);
		} else {
			return this.getRuleContext(i, Reshape_valuesContext);
		}
	}
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return NotebookmlParser.RULE_reshape; }
	// @Override
	public enterRule(listener: NotebookmlListener): void {
		if (listener.enterReshape) {
			listener.enterReshape(this);
		}
	}
	// @Override
	public exitRule(listener: NotebookmlListener): void {
		if (listener.exitReshape) {
			listener.exitReshape(this);
		}
	}
	// @Override
	public accept<Result>(visitor: NotebookmlVisitor<Result>): Result {
		if (visitor.visitReshape) {
			return visitor.visitReshape(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


export class Reshape_valuesContext extends ParserRuleContext {
	public _reshape_value: Token;
	public NUMBER(): TerminalNode { return this.getToken(NotebookmlParser.NUMBER, 0); }
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return NotebookmlParser.RULE_reshape_values; }
	// @Override
	public enterRule(listener: NotebookmlListener): void {
		if (listener.enterReshape_values) {
			listener.enterReshape_values(this);
		}
	}
	// @Override
	public exitRule(listener: NotebookmlListener): void {
		if (listener.exitReshape_values) {
			listener.exitReshape_values(this);
		}
	}
	// @Override
	public accept<Result>(visitor: NotebookmlVisitor<Result>): Result {
		if (visitor.visitReshape_values) {
			return visitor.visitReshape_values(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


export class NormalizationContext extends ParserRuleContext {
	public normalization_elem(): Normalization_elemContext[];
	public normalization_elem(i: number): Normalization_elemContext;
	public normalization_elem(i?: number): Normalization_elemContext | Normalization_elemContext[] {
		if (i === undefined) {
			return this.getRuleContexts(Normalization_elemContext);
		} else {
			return this.getRuleContext(i, Normalization_elemContext);
		}
	}
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return NotebookmlParser.RULE_normalization; }
	// @Override
	public enterRule(listener: NotebookmlListener): void {
		if (listener.enterNormalization) {
			listener.enterNormalization(this);
		}
	}
	// @Override
	public exitRule(listener: NotebookmlListener): void {
		if (listener.exitNormalization) {
			listener.exitNormalization(this);
		}
	}
	// @Override
	public accept<Result>(visitor: NotebookmlVisitor<Result>): Result {
		if (visitor.visitNormalization) {
			return visitor.visitNormalization(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


export class Normalization_elemContext extends ParserRuleContext {
	public _type: Token;
	public _size: Token;
	public TYPE(): TerminalNode { return this.getToken(NotebookmlParser.TYPE, 0); }
	public NUMBER(): TerminalNode { return this.getToken(NotebookmlParser.NUMBER, 0); }
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return NotebookmlParser.RULE_normalization_elem; }
	// @Override
	public enterRule(listener: NotebookmlListener): void {
		if (listener.enterNormalization_elem) {
			listener.enterNormalization_elem(this);
		}
	}
	// @Override
	public exitRule(listener: NotebookmlListener): void {
		if (listener.exitNormalization_elem) {
			listener.exitNormalization_elem(this);
		}
	}
	// @Override
	public accept<Result>(visitor: NotebookmlVisitor<Result>): Result {
		if (visitor.visitNormalization_elem) {
			return visitor.visitNormalization_elem(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


export class Data_miningContext extends ParserRuleContext {
	public network(): NetworkContext {
		return this.getRuleContext(0, NetworkContext);
	}
	public params(): ParamsContext {
		return this.getRuleContext(0, ParamsContext);
	}
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return NotebookmlParser.RULE_data_mining; }
	// @Override
	public enterRule(listener: NotebookmlListener): void {
		if (listener.enterData_mining) {
			listener.enterData_mining(this);
		}
	}
	// @Override
	public exitRule(listener: NotebookmlListener): void {
		if (listener.exitData_mining) {
			listener.exitData_mining(this);
		}
	}
	// @Override
	public accept<Result>(visitor: NotebookmlVisitor<Result>): Result {
		if (visitor.visitData_mining) {
			return visitor.visitData_mining(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


export class NetworkContext extends ParserRuleContext {
	public sequential(): SequentialContext {
		return this.getRuleContext(0, SequentialContext);
	}
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return NotebookmlParser.RULE_network; }
	// @Override
	public enterRule(listener: NotebookmlListener): void {
		if (listener.enterNetwork) {
			listener.enterNetwork(this);
		}
	}
	// @Override
	public exitRule(listener: NotebookmlListener): void {
		if (listener.exitNetwork) {
			listener.exitNetwork(this);
		}
	}
	// @Override
	public accept<Result>(visitor: NotebookmlVisitor<Result>): Result {
		if (visitor.visitNetwork) {
			return visitor.visitNetwork(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


export class SequentialContext extends ParserRuleContext {
	public linear(): LinearContext[];
	public linear(i: number): LinearContext;
	public linear(i?: number): LinearContext | LinearContext[] {
		if (i === undefined) {
			return this.getRuleContexts(LinearContext);
		} else {
			return this.getRuleContext(i, LinearContext);
		}
	}
	public tanh(): TanhContext[];
	public tanh(i: number): TanhContext;
	public tanh(i?: number): TanhContext | TanhContext[] {
		if (i === undefined) {
			return this.getRuleContexts(TanhContext);
		} else {
			return this.getRuleContext(i, TanhContext);
		}
	}
	public softmax(): SoftmaxContext[];
	public softmax(i: number): SoftmaxContext;
	public softmax(i?: number): SoftmaxContext | SoftmaxContext[] {
		if (i === undefined) {
			return this.getRuleContexts(SoftmaxContext);
		} else {
			return this.getRuleContext(i, SoftmaxContext);
		}
	}
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return NotebookmlParser.RULE_sequential; }
	// @Override
	public enterRule(listener: NotebookmlListener): void {
		if (listener.enterSequential) {
			listener.enterSequential(this);
		}
	}
	// @Override
	public exitRule(listener: NotebookmlListener): void {
		if (listener.exitSequential) {
			listener.exitSequential(this);
		}
	}
	// @Override
	public accept<Result>(visitor: NotebookmlVisitor<Result>): Result {
		if (visitor.visitSequential) {
			return visitor.visitSequential(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


export class LinearContext extends ParserRuleContext {
	public _linear_in: Token;
	public _linear_out: Token;
	public NUMBER(): TerminalNode[];
	public NUMBER(i: number): TerminalNode;
	public NUMBER(i?: number): TerminalNode | TerminalNode[] {
		if (i === undefined) {
			return this.getTokens(NotebookmlParser.NUMBER);
		} else {
			return this.getToken(NotebookmlParser.NUMBER, i);
		}
	}
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return NotebookmlParser.RULE_linear; }
	// @Override
	public enterRule(listener: NotebookmlListener): void {
		if (listener.enterLinear) {
			listener.enterLinear(this);
		}
	}
	// @Override
	public exitRule(listener: NotebookmlListener): void {
		if (listener.exitLinear) {
			listener.exitLinear(this);
		}
	}
	// @Override
	public accept<Result>(visitor: NotebookmlVisitor<Result>): Result {
		if (visitor.visitLinear) {
			return visitor.visitLinear(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


export class TanhContext extends ParserRuleContext {
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return NotebookmlParser.RULE_tanh; }
	// @Override
	public enterRule(listener: NotebookmlListener): void {
		if (listener.enterTanh) {
			listener.enterTanh(this);
		}
	}
	// @Override
	public exitRule(listener: NotebookmlListener): void {
		if (listener.exitTanh) {
			listener.exitTanh(this);
		}
	}
	// @Override
	public accept<Result>(visitor: NotebookmlVisitor<Result>): Result {
		if (visitor.visitTanh) {
			return visitor.visitTanh(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


export class SoftmaxContext extends ParserRuleContext {
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return NotebookmlParser.RULE_softmax; }
	// @Override
	public enterRule(listener: NotebookmlListener): void {
		if (listener.enterSoftmax) {
			listener.enterSoftmax(this);
		}
	}
	// @Override
	public exitRule(listener: NotebookmlListener): void {
		if (listener.exitSoftmax) {
			listener.exitSoftmax(this);
		}
	}
	// @Override
	public accept<Result>(visitor: NotebookmlVisitor<Result>): Result {
		if (visitor.visitSoftmax) {
			return visitor.visitSoftmax(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


export class ParamsContext extends ParserRuleContext {
	public loss(): LossContext {
		return this.getRuleContext(0, LossContext);
	}
	public optimizers(): OptimizersContext {
		return this.getRuleContext(0, OptimizersContext);
	}
	public learningRate(): LearningRateContext {
		return this.getRuleContext(0, LearningRateContext);
	}
	public nbEpochs(): NbEpochsContext {
		return this.getRuleContext(0, NbEpochsContext);
	}
	public batchSize(): BatchSizeContext {
		return this.getRuleContext(0, BatchSizeContext);
	}
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return NotebookmlParser.RULE_params; }
	// @Override
	public enterRule(listener: NotebookmlListener): void {
		if (listener.enterParams) {
			listener.enterParams(this);
		}
	}
	// @Override
	public exitRule(listener: NotebookmlListener): void {
		if (listener.exitParams) {
			listener.exitParams(this);
		}
	}
	// @Override
	public accept<Result>(visitor: NotebookmlVisitor<Result>): Result {
		if (visitor.visitParams) {
			return visitor.visitParams(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


export class LossContext extends ParserRuleContext {
	public _loss_type: Token;
	public LOSS(): TerminalNode { return this.getToken(NotebookmlParser.LOSS, 0); }
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return NotebookmlParser.RULE_loss; }
	// @Override
	public enterRule(listener: NotebookmlListener): void {
		if (listener.enterLoss) {
			listener.enterLoss(this);
		}
	}
	// @Override
	public exitRule(listener: NotebookmlListener): void {
		if (listener.exitLoss) {
			listener.exitLoss(this);
		}
	}
	// @Override
	public accept<Result>(visitor: NotebookmlVisitor<Result>): Result {
		if (visitor.visitLoss) {
			return visitor.visitLoss(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


export class OptimizersContext extends ParserRuleContext {
	public _optimizers_type: Token;
	public OPTIMIZERS(): TerminalNode { return this.getToken(NotebookmlParser.OPTIMIZERS, 0); }
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return NotebookmlParser.RULE_optimizers; }
	// @Override
	public enterRule(listener: NotebookmlListener): void {
		if (listener.enterOptimizers) {
			listener.enterOptimizers(this);
		}
	}
	// @Override
	public exitRule(listener: NotebookmlListener): void {
		if (listener.exitOptimizers) {
			listener.exitOptimizers(this);
		}
	}
	// @Override
	public accept<Result>(visitor: NotebookmlVisitor<Result>): Result {
		if (visitor.visitOptimizers) {
			return visitor.visitOptimizers(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


export class LearningRateContext extends ParserRuleContext {
	public _learningRate_nb: Token;
	public DOUBLE(): TerminalNode { return this.getToken(NotebookmlParser.DOUBLE, 0); }
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return NotebookmlParser.RULE_learningRate; }
	// @Override
	public enterRule(listener: NotebookmlListener): void {
		if (listener.enterLearningRate) {
			listener.enterLearningRate(this);
		}
	}
	// @Override
	public exitRule(listener: NotebookmlListener): void {
		if (listener.exitLearningRate) {
			listener.exitLearningRate(this);
		}
	}
	// @Override
	public accept<Result>(visitor: NotebookmlVisitor<Result>): Result {
		if (visitor.visitLearningRate) {
			return visitor.visitLearningRate(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


export class NbEpochsContext extends ParserRuleContext {
	public _nbEpochs_nb: Token;
	public NUMBER(): TerminalNode { return this.getToken(NotebookmlParser.NUMBER, 0); }
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return NotebookmlParser.RULE_nbEpochs; }
	// @Override
	public enterRule(listener: NotebookmlListener): void {
		if (listener.enterNbEpochs) {
			listener.enterNbEpochs(this);
		}
	}
	// @Override
	public exitRule(listener: NotebookmlListener): void {
		if (listener.exitNbEpochs) {
			listener.exitNbEpochs(this);
		}
	}
	// @Override
	public accept<Result>(visitor: NotebookmlVisitor<Result>): Result {
		if (visitor.visitNbEpochs) {
			return visitor.visitNbEpochs(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


export class BatchSizeContext extends ParserRuleContext {
	public _batchSize_nb: Token;
	public NUMBER(): TerminalNode { return this.getToken(NotebookmlParser.NUMBER, 0); }
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return NotebookmlParser.RULE_batchSize; }
	// @Override
	public enterRule(listener: NotebookmlListener): void {
		if (listener.enterBatchSize) {
			listener.enterBatchSize(this);
		}
	}
	// @Override
	public exitRule(listener: NotebookmlListener): void {
		if (listener.exitBatchSize) {
			listener.exitBatchSize(this);
		}
	}
	// @Override
	public accept<Result>(visitor: NotebookmlVisitor<Result>): Result {
		if (visitor.visitBatchSize) {
			return visitor.visitBatchSize(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


export class ValidationContext extends ParserRuleContext {
	public diagram(): DiagramContext[];
	public diagram(i: number): DiagramContext;
	public diagram(i?: number): DiagramContext | DiagramContext[] {
		if (i === undefined) {
			return this.getRuleContexts(DiagramContext);
		} else {
			return this.getRuleContext(i, DiagramContext);
		}
	}
	public score(): ScoreContext[];
	public score(i: number): ScoreContext;
	public score(i?: number): ScoreContext | ScoreContext[] {
		if (i === undefined) {
			return this.getRuleContexts(ScoreContext);
		} else {
			return this.getRuleContext(i, ScoreContext);
		}
	}
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return NotebookmlParser.RULE_validation; }
	// @Override
	public enterRule(listener: NotebookmlListener): void {
		if (listener.enterValidation) {
			listener.enterValidation(this);
		}
	}
	// @Override
	public exitRule(listener: NotebookmlListener): void {
		if (listener.exitValidation) {
			listener.exitValidation(this);
		}
	}
	// @Override
	public accept<Result>(visitor: NotebookmlVisitor<Result>): Result {
		if (visitor.visitValidation) {
			return visitor.visitValidation(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


export class DiagramContext extends ParserRuleContext {
	public _diagram_name: Token;
	public DIAGRAMS(): TerminalNode { return this.getToken(NotebookmlParser.DIAGRAMS, 0); }
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return NotebookmlParser.RULE_diagram; }
	// @Override
	public enterRule(listener: NotebookmlListener): void {
		if (listener.enterDiagram) {
			listener.enterDiagram(this);
		}
	}
	// @Override
	public exitRule(listener: NotebookmlListener): void {
		if (listener.exitDiagram) {
			listener.exitDiagram(this);
		}
	}
	// @Override
	public accept<Result>(visitor: NotebookmlVisitor<Result>): Result {
		if (visitor.visitDiagram) {
			return visitor.visitDiagram(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


export class ScoreContext extends ParserRuleContext {
	public _score_type: Token;
	public SCORE_TYPE(): TerminalNode { return this.getToken(NotebookmlParser.SCORE_TYPE, 0); }
	constructor(parent: ParserRuleContext | undefined, invokingState: number) {
		super(parent, invokingState);
	}
	// @Override
	public get ruleIndex(): number { return NotebookmlParser.RULE_score; }
	// @Override
	public enterRule(listener: NotebookmlListener): void {
		if (listener.enterScore) {
			listener.enterScore(this);
		}
	}
	// @Override
	public exitRule(listener: NotebookmlListener): void {
		if (listener.exitScore) {
			listener.exitScore(this);
		}
	}
	// @Override
	public accept<Result>(visitor: NotebookmlVisitor<Result>): Result {
		if (visitor.visitScore) {
			return visitor.visitScore(this);
		} else {
			return visitor.visitChildren(this);
		}
	}
}


