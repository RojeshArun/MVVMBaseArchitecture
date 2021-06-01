package com.rojesh.bootcamp.learndagger.di.component

import com.rojesh.bootcamp.learndagger.di.ViewHolderScope
import com.rojesh.bootcamp.learndagger.di.module.ViewHolderModule
import dagger.Component

@ViewHolderScope
@Component(dependencies = [ApplicationComponent::class], modules = [ViewHolderModule::class])
interface ViewHolderComponent {


}
