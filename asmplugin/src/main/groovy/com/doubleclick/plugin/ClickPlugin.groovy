package com.doubleclick.plugin

import com.android.build.gradle.AppExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

 class ClickPlugin implements Plugin<Project>{


    @Override
    void apply(Project project) {

        println("dlPlguin is executed!!!!!!")
        def android = project.extensions.getByType(AppExtension)
        ClickTransform transform=new ClickTransform()
        android.registerTransform(transform)
    }
}