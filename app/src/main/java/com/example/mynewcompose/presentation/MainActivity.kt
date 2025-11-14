package com.example.mynewcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mynewcompose.presentation.components.oldCourse.MyIcon
import com.example.mynewcompose.presentation.components.progress.MyParentProgress
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
            MyNewComposeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    testCapitulos(
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }

    @Composable
    private fun testSecciones() {
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
    private fun testCapitulos(modifier: Modifier) {
//        MyFirstButtonCounter()
//        MySecondButtonCounter()
//        MyThirdButtonCounter()
//        TapMyText1(modifier)
//        TapMySharingTexts(modifier)
//        MyTextFieldParent(modifier)
//        MyButtonParent(modifier)
//        MyParentImage(modifier)
        MyParentProgress(modifier)
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            testCapitulos(
                modifier = Modifier.padding(innerPadding),
            )
        }
    }
}
