package com.example.statehoistingsample

import androidx.compose.runtime.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.*
import com.example.statehoistingsample.screen.ClientForm
import com.example.statehoistingsample.screen.ClientType
import org.junit.Rule
import org.junit.Test

class ClientFormTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    /**
     * 個人が選択されているとき、氏名の入力欄が表示されることを確認
     */
    @Test
    fun testPersonalNameFieldIsDisplayed() {
        composeTestRule.setContent {
            ClientForm(
                clientType = ClientType.Personal,
                onClientTypeChange = {},
                name = "テストユーザー",
                onNameChange = {},
                companyName = "",
                onCompanyNameChange = {},
                contactName = "",
                onContactNameChange = {}
            )
        }

        composeTestRule
            .onNodeWithText("氏名")
            .assertExists()
    }

    /**
     * 法人が選択されているとき、会社名と担当者名の入力欄が表示されることを確認
     */
    @Test
    fun testCorporateFieldsDisplayed() {
        composeTestRule.setContent {
            ClientForm(
                clientType = ClientType.Corporate,
                onClientTypeChange = {},
                name = "",
                onNameChange = {},
                companyName = "株式会社テスト",
                onCompanyNameChange = {},
                contactName = "山田",
                onContactNameChange = {}
            )
        }

        composeTestRule.onNodeWithText("会社名").assertExists()
        composeTestRule.onNodeWithText("担当者名").assertExists()
    }

    /**
     * 氏名の入力欄にテキストを入力できることを確認
     */
    @Test
    fun testNameInputReflectsText() {
        composeTestRule.setContent {
            var name by remember { mutableStateOf("") }

            ClientForm(
                clientType = ClientType.Personal,
                onClientTypeChange = {},
                name = name,
                onNameChange = { name = it },
                companyName = "",
                onCompanyNameChange = {},
                contactName = "",
                onContactNameChange = {}
            )
        }

        val testInput = "山田 太郎"

        // "氏名" フィールドに入力して、そのテキストが表示されるか確認
        composeTestRule.onNodeWithText("氏名")
            .performTextInput(testInput)

        composeTestRule.onNodeWithText(testInput)
            .assertExists()
    }
}
