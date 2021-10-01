package com.github.antoniohbmonteiro.androidtemplates.services

import com.intellij.openapi.project.Project
import com.github.antoniohbmonteiro.androidtemplates.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
