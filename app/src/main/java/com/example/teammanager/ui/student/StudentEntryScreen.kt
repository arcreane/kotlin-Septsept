package com.example.teammanager.ui.student

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.teammanager.ui.util.DegreeUtil
import com.example.teammanager.R
import com.example.teammanager.ui.component.DegreeDropdownMenu
import com.example.teammanager.ui.component.LevelDropdownMenu


@SuppressLint("StringFormatInvalid")
@Composable
fun StudentEntryScreen() {

    var firstname by rememberSaveable { mutableStateOf("") };
    var lastname by rememberSaveable { mutableStateOf("") };
    var level by rememberSaveable { mutableStateOf("1") }
    var isMaxLevelError by rememberSaveable { mutableStateOf(false) }
    var degree by rememberSaveable { mutableStateOf(DegreeUtil.Degree.Programming.name) }
    val context = LocalContext.current


    Column(
        modifier = Modifier
            .padding(16.dp, 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Text(
            text = stringResource(id = R.string.add_student),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.displaySmall
        )

        Spacer(modifier = Modifier.padding(8.dp))

        Text(
            text = stringResource(id = R.string.student_firstname),
            style = MaterialTheme.typography.bodyLarge
        )

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = firstname,
            onValueChange = { firstname = it },
            placeholder = { Text(text = "Firstname") },
        )

        Text(
            text = stringResource(id = R.string.student_lastname),
            style = MaterialTheme.typography.bodyLarge
        )

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = lastname,
            onValueChange = { lastname = it },
            placeholder = { Text(text = "Lastname") },
        )

        Spacer(modifier = Modifier.padding(4.dp))

        LevelDropdownMenu { level = it }

        DegreeDropdownMenu { degree = it }

        Spacer(modifier = Modifier.padding(8.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .align(Alignment.CenterHorizontally),
            onClick = {
                StudentEntryValidation(
                    lastname = lastname,
                    firstname = firstname,
                    onInvalidate = {
                        Toast.makeText(
                            context,
                            context.getString(R.string.value_is_empty, context.getString(it)),
                            Toast.LENGTH_LONG
                        ).show()
                    },
                    onValidate = {

                        Toast.makeText(
                            context,
                            context.getString(R.string.success),
                            Toast.LENGTH_LONG
                        ).show()
                    }
                )
            },
            shape = MaterialTheme.shapes.extraLarge
        ) {
            Text(
                text = stringResource(id = R.string.save),
                style = MaterialTheme.typography.bodyLarge
            )
        }

        if (isMaxLevelError) {
            Text(
                text = stringResource(id = R.string.maxLevelError),
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
            )
        }

    }
}


