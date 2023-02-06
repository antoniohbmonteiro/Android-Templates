package com.github.antoniohbmonteiro.androidtemplates.other.setup

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.addAllKotlinDependencies
import com.github.antoniohbmonteiro.androidtemplates.listeners.MyProjectManagerListener.Companion.projectInstance
import com.github.antoniohbmonteiro.androidtemplates.other.setup.src.app_package.someActivity
import com.github.antoniohbmonteiro.androidtemplates.other.setup.src.app_package.someActivityLayout
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.PsiManager
import org.jetbrains.kotlin.idea.KotlinLanguage

fun RecipeExecutor.mviSetup(
    moduleData: ModuleTemplateData,
    packageName: String,
    entityName: String,
    layoutName: String
) {
    val (projectData, srcOut, resOut) = moduleData

    addAllKotlinDependencies(moduleData)

    val activityClass = "${entityName}sActivity"
    val activityTitle = "$entityName Activity"
    // This will generate new manifest (with activity) to merge it with existing
    generateManifest(moduleData, activityClass, activityTitle, packageName,
        isLauncher = false, hasNoActionBar = true, generateActivityTitle = true)

    save(
        someActivity(packageName, entityName, layoutName, projectData),
        srcOut.resolve("$activityClass.kt")
    )
    save(someActivityLayout(packageName, entityName),
        resOut.resolve("layout/$layoutName.xml")
    )
}