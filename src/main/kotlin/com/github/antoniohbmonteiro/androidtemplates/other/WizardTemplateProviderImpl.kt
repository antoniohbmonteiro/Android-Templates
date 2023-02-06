package com.github.antoniohbmonteiro.androidtemplates.other

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import com.github.antoniohbmonteiro.androidtemplates.other.setup.mviSetupTemplate

class WizardTemplateProviderImpl  : WizardTemplateProvider() {
    override fun getTemplates(): List<Template> = listOf(mviSetupTemplate)
}