package com.example.mynewcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mynewcompose.presentation.components.button.MyFab
import com.example.mynewcompose.presentation.components.dropdownMenu.MyExposedDropdownMenu
import com.example.mynewcompose.presentation.components.oldCourse.MyIcon
import com.example.mynewcompose.presentation.components.scaffold.MyParentScaffold
import com.example.mynewcompose.presentation.components.scaffold.MyTopAppBar
import com.example.mynewcompose.ui.theme.MyNewComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Old way
        /**
         setContent {

         MyOldComposeTheme {
         // A surface container using the 'background' color from the theme
         Surface(
         modifier = Modifier.fillMaxSize(),
         color = MaterialTheme.colorScheme.background,
         ) {
         // testSecciones
         }
         }

         }
         */
        // New way
        setContent {
            val snackbarHostState = remember { SnackbarHostState() }
            MyNewComposeAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { MyTopAppBar() },
                    snackbarHost = {
                        SnackbarHost(hostState = snackbarHostState)
                    },
                    floatingActionButton = { MyFab() },
                    floatingActionButtonPosition = FabPosition.Center,
                ) { innerPadding ->
//                    TestCapitulos(
//                        modifier = Modifier.padding(innerPadding),
//                    )
                    ScaffoldCapitulo(
                        modifier = Modifier.padding(innerPadding),
                        snackbarHostState = snackbarHostState,
                    )
                }
            }
        }
    }

    @Composable
    private fun TestSecciones() {
//        /* Sección 3 */
//        MyStateExample()
//
//        /* Sección 4 */
//        MyTextField()
//        MyTextFieldAdvanced()
//        showMyTextFieldOutlined()
//
//        /* Sección 5 */
//        var myText by remember { mutableStateOf("") }
//        showMyTextFieldOutlinedStateHoisting(myText) { myText = it }
//
//        /* Sección 6 */
//        MyButtonExample()
//        MyOutlinedButtonExample()
//
//        /* Sección 7 */
//        myImage()
        MyIcon()
    }

    @Composable
    private fun TestCapitulos(modifier: Modifier) {
//        MyFirstButtonCounter()
//        MySecondButtonCounter()
//        MyThirdButtonCounter()
//        TapMyText1(modifier)
//        TapMySharingTexts(modifier)
//        MyTextFieldParent(modifier)
//        MyButtonParent(modifier)
//        MyParentImage(modifier)
//        MyParentProgress(modifier)
//        MyParentProgressAdvance(modifier)
//        MyParentLottieProgress(modifier)
//        MyParentSwitchControl(modifier)
//        MyParentCheckbox(modifier)
//        MyParentAdvanceCheckbox(modifier)
//        MyParentTriStateCheckBox(modifier)
//        MyParentRadioButtonCheckBox(modifier)
//        MyParentAdvanceRadioButtonCheckBox(modifier)
//        MyParentSlider(modifier)
//        MyAdvanceParentSlider(modifier)
//        MyRangeParentSlider(modifier)
//        MyDropDownItemParent(modifier)
//        MyParentDropdownMenu(modifier)
        MyExposedDropdownMenu(modifier)
    }

    @Composable
    fun ScaffoldCapitulo(
        modifier: Modifier,
        snackbarHostState: SnackbarHostState,
    ) {
        MyParentScaffold(modifier, snackbarHostState)
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            TestCapitulos(
                modifier = Modifier.padding(innerPadding),
            )
        }
    }
}
