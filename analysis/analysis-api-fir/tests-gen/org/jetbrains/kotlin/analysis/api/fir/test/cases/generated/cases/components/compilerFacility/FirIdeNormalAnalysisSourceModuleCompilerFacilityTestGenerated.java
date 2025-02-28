/*
 * Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.api.fir.test.cases.generated.cases.components.compilerFacility;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.kotlin.analysis.api.fir.test.configurators.AnalysisApiFirTestConfiguratorFactory;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiTestConfiguratorFactoryData;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiTestConfigurator;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.TestModuleKind;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.FrontendKind;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisSessionMode;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiMode;
import org.jetbrains.kotlin.analysis.api.impl.base.test.cases.components.compilerFacility.AbstractCompilerFacilityTest;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("analysis/analysis-api/testData/components/compilerFacility/compilation")
@TestDataPath("$PROJECT_ROOT")
public class FirIdeNormalAnalysisSourceModuleCompilerFacilityTestGenerated extends AbstractCompilerFacilityTest {
    @NotNull
    @Override
    public AnalysisApiTestConfigurator getConfigurator() {
        return AnalysisApiFirTestConfiguratorFactory.INSTANCE.createConfigurator(
            new AnalysisApiTestConfiguratorFactoryData(
                FrontendKind.Fir,
                TestModuleKind.Source,
                AnalysisSessionMode.Normal,
                AnalysisApiMode.Ide
            )
        );
    }

    @Test
    public void testAllFilesPresentInCompilation() throws Exception {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/compilerFacility/compilation"), Pattern.compile("^([^.]+)\\.kt$"), null, true);
    }

    @Test
    @TestMetadata("classKinds.kt")
    public void testClassKinds() throws Exception {
        runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/classKinds.kt");
    }

    @Test
    @TestMetadata("imports.kt")
    public void testImports() throws Exception {
        runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/imports.kt");
    }

    @Test
    @TestMetadata("multipleFiles.kt")
    public void testMultipleFiles() throws Exception {
        runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/multipleFiles.kt");
    }

    @Test
    @TestMetadata("simple.kt")
    public void testSimple() throws Exception {
        runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/simple.kt");
    }

    @Nested
    @TestMetadata("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments")
    @TestDataPath("$PROJECT_ROOT")
    public class CodeFragments {
        @Test
        public void testAllFilesPresentInCodeFragments() throws Exception {
            KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments"), Pattern.compile("^([^.]+)\\.kt$"), null, true);
        }

        @Test
        @TestMetadata("annotationUsage.kt")
        public void testAnnotationUsage() throws Exception {
            runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/annotationUsage.kt");
        }

        @Test
        @TestMetadata("customName.kt")
        public void testCustomName() throws Exception {
            runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/customName.kt");
        }

        @Test
        @TestMetadata("duplicateLibrary.kt")
        public void testDuplicateLibrary() throws Exception {
            runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/duplicateLibrary.kt");
        }

        @Test
        @TestMetadata("fragmentFunction.kt")
        public void testFragmentFunction() throws Exception {
            runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/fragmentFunction.kt");
        }

        @Test
        @TestMetadata("imports.kt")
        public void testImports() throws Exception {
            runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/imports.kt");
        }

        @Test
        @TestMetadata("inlineFunctionUsage.kt")
        public void testInlineFunctionUsage() throws Exception {
            runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/inlineFunctionUsage.kt");
        }

        @Test
        @TestMetadata("inlineFunctionUsageSource.kt")
        public void testInlineFunctionUsageSource() throws Exception {
            runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/inlineFunctionUsageSource.kt");
        }

        @Test
        @TestMetadata("local.kt")
        public void testLocal() throws Exception {
            runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/local.kt");
        }

        @Test
        @TestMetadata("simple.kt")
        public void testSimple() throws Exception {
            runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/simple.kt");
        }

        @Test
        @TestMetadata("syntaxError.kt")
        public void testSyntaxError() throws Exception {
            runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/syntaxError.kt");
        }

        @Nested
        @TestMetadata("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing")
        @TestDataPath("$PROJECT_ROOT")
        public class Capturing {
            @Test
            public void testAllFilesPresentInCapturing() throws Exception {
                KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing"), Pattern.compile("^([^.]+)\\.kt$"), null, true);
            }

            @Test
            @TestMetadata("contextReceiver.kt")
            public void testContextReceiver() throws Exception {
                runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing/contextReceiver.kt");
            }

            @Test
            @TestMetadata("contextReceiverExplicit.kt")
            public void testContextReceiverExplicit() throws Exception {
                runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing/contextReceiverExplicit.kt");
            }

            @Test
            @TestMetadata("extensionReceiver.kt")
            public void testExtensionReceiver() throws Exception {
                runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing/extensionReceiver.kt");
            }

            @Test
            @TestMetadata("extensionReceiverExplicit.kt")
            public void testExtensionReceiverExplicit() throws Exception {
                runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing/extensionReceiverExplicit.kt");
            }

            @Test
            @TestMetadata("extensionReceiverLabeled.kt")
            public void testExtensionReceiverLabeled() throws Exception {
                runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing/extensionReceiverLabeled.kt");
            }

            @Test
            @TestMetadata("extensionReceiverProperty.kt")
            public void testExtensionReceiverProperty() throws Exception {
                runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing/extensionReceiverProperty.kt");
            }

            @Test
            @TestMetadata("extensionReceiverPropertyExplicit.kt")
            public void testExtensionReceiverPropertyExplicit() throws Exception {
                runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing/extensionReceiverPropertyExplicit.kt");
            }

            @Test
            @TestMetadata("extensionReceiverPropertyLabeled.kt")
            public void testExtensionReceiverPropertyLabeled() throws Exception {
                runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing/extensionReceiverPropertyLabeled.kt");
            }

            @Test
            @TestMetadata("initializer.kt")
            public void testInitializer() throws Exception {
                runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing/initializer.kt");
            }

            @Test
            @TestMetadata("local.kt")
            public void testLocal() throws Exception {
                runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing/local.kt");
            }

            @Test
            @TestMetadata("localDelegatedProperty.kt")
            public void testLocalDelegatedProperty() throws Exception {
                runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing/localDelegatedProperty.kt");
            }

            @Test
            @TestMetadata("localFunction.kt")
            public void testLocalFunction() throws Exception {
                runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing/localFunction.kt");
            }

            @Test
            @TestMetadata("localFunctionContainingClassClosure.kt")
            public void testLocalFunctionContainingClassClosure() throws Exception {
                runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing/localFunctionContainingClassClosure.kt");
            }

            @Test
            @TestMetadata("localFunctionExtensionReceiverClosure.kt")
            public void testLocalFunctionExtensionReceiverClosure() throws Exception {
                runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing/localFunctionExtensionReceiverClosure.kt");
            }

            @Test
            @TestMetadata("localFunctionLambdaParameterClosure.kt")
            public void testLocalFunctionLambdaParameterClosure() throws Exception {
                runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing/localFunctionLambdaParameterClosure.kt");
            }

            @Test
            @TestMetadata("localFunctionLocalClosure.kt")
            public void testLocalFunctionLocalClosure() throws Exception {
                runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing/localFunctionLocalClosure.kt");
            }

            @Test
            @TestMetadata("localFunctionLocalClosureMutating.kt")
            public void testLocalFunctionLocalClosureMutating() throws Exception {
                runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing/localFunctionLocalClosureMutating.kt");
            }

            @Test
            @TestMetadata("localFunctionMultipleCapturing.kt")
            public void testLocalFunctionMultipleCapturing() throws Exception {
                runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing/localFunctionMultipleCapturing.kt");
            }

            @Test
            @TestMetadata("localFunctionParameterClosure.kt")
            public void testLocalFunctionParameterClosure() throws Exception {
                runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing/localFunctionParameterClosure.kt");
            }

            @Test
            @TestMetadata("localMutated.kt")
            public void testLocalMutated() throws Exception {
                runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing/localMutated.kt");
            }

            @Test
            @TestMetadata("localVariable.kt")
            public void testLocalVariable() throws Exception {
                runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing/localVariable.kt");
            }

            @Test
            @TestMetadata("multipleClassAndFunctionContextReceivers.kt")
            public void testMultipleClassAndFunctionContextReceivers() throws Exception {
                runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing/multipleClassAndFunctionContextReceivers.kt");
            }

            @Test
            @TestMetadata("multipleClassContextReceivers.kt")
            public void testMultipleClassContextReceivers() throws Exception {
                runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing/multipleClassContextReceivers.kt");
            }

            @Test
            @TestMetadata("multipleFunctionContextReceivers.kt")
            public void testMultipleFunctionContextReceivers() throws Exception {
                runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing/multipleFunctionContextReceivers.kt");
            }

            @Test
            @TestMetadata("nestedOuterClass.kt")
            public void testNestedOuterClass() throws Exception {
                runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing/nestedOuterClass.kt");
            }

            @Test
            @TestMetadata("objectFunction.kt")
            public void testObjectFunction() throws Exception {
                runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing/objectFunction.kt");
            }

            @Test
            @TestMetadata("outerClass.kt")
            public void testOuterClass() throws Exception {
                runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing/outerClass.kt");
            }

            @Test
            @TestMetadata("outerClassMutated.kt")
            public void testOuterClassMutated() throws Exception {
                runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing/outerClassMutated.kt");
            }

            @Test
            @TestMetadata("outerClassMutatedPrivate.kt")
            public void testOuterClassMutatedPrivate() throws Exception {
                runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing/outerClassMutatedPrivate.kt");
            }

            @Test
            @TestMetadata("preferCorrectResolve.kt")
            public void testPreferCorrectResolve() throws Exception {
                runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing/preferCorrectResolve.kt");
            }

            @Test
            @TestMetadata("privateMemberCall.kt")
            public void testPrivateMemberCall() throws Exception {
                runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing/privateMemberCall.kt");
            }

            @Test
            @TestMetadata("secondClassContextReceiver.kt")
            public void testSecondClassContextReceiver() throws Exception {
                runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing/secondClassContextReceiver.kt");
            }

            @Test
            @TestMetadata("singleClassContextReceiver.kt")
            public void testSingleClassContextReceiver() throws Exception {
                runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing/singleClassContextReceiver.kt");
            }

            @Test
            @TestMetadata("smartCastExtensionReceiver.kt")
            public void testSmartCastExtensionReceiver() throws Exception {
                runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing/smartCastExtensionReceiver.kt");
            }

            @Test
            @TestMetadata("smartCastValueParameter.kt")
            public void testSmartCastValueParameter() throws Exception {
                runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing/smartCastValueParameter.kt");
            }

            @Test
            @TestMetadata("valueParameter.kt")
            public void testValueParameter() throws Exception {
                runTest("analysis/analysis-api/testData/components/compilerFacility/compilation/codeFragments/capturing/valueParameter.kt");
            }
        }
    }
}
