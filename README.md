![Build Application](https://github.com/Fbada006/Clean_Architecture_Template_Crypto/workflows/Build%20Application/badge.svg)
![Run KtLint](https://github.com/Fbada006/Clean_Architecture_Template_Crypto/workflows/Run%20KtLint/badge.svg)
# Clean_Architecture_Template_Crypto
Don't you get tired of writing apps that parse data from the API from scratch all the time? This app 
seeks to simplify this by providing a template that you can modify and use on the fly using clean 
architecture. It gets data from the the [coingecko API](https://www.coingecko.com/en/api#explore-api) 
and displays the cryptos using clean architecture and MVVM.


## Prerequisite

minSdkVersion -> 21

Gradle build system

Kotlin

You do not need an API key for this project


## TOC

- [Architecture](#architecture)
- [Libraries](#libraries)
- [Extras](#extras)

## Architecture

The App is not organized into multiple modules following the principles of
the Presentation, Domain, and Data Layers.
The presentation layer handles the UI work with the logic contained in the **ViewModel**.
The UI uses a **LiveData** object from the ViewModel and observes it using the **Observer Pattern**.
A ListAdapter handles the actual displaying of the cryptos. Data over the network is retrieved using
**retrofit**, **Flow** and **coroutines** to handle background work asynchronously. Additionally, note that
the ViewModel uses the **viewModelScope** to launch the couroutines while Fragments use the **viewLifeCycleOwner**
to observe data.


## Libraries

This app takes use of the following libraries:

- [Jetpack](https://developer.android.com/jetpack)🚀
  - [Viewmodel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Manage UI data to survive configuration changes and is lifecycle-aware
  - [Navigation](https://developer.android.com/guide/navigation/) - Handle everything needed for in-app navigation
  - [Flow](https://kotlinlang.org/docs/reference/coroutines/flow.html) - The new stream processing API
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Notify views when data changes
- [Retrofit](https://square.github.io/retrofit/) - type safe http client with coroutines support
- [Moshi](https://github.com/square/moshi) - Modern JSON library for Android and Java
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - Injection library for Android that reduces
- [okhttp-logging-interceptor](https://github.com/square/okhttp/blob/master/okhttp-logging-interceptor/README.md) - logging HTTP request related data.
- [kotlinx.coroutines](https://github.com/Kotlin/kotlinx.coroutines) - Library Support for coroutines
- [Timber](https://github.com/JakeWharton/timber) - A logger with a small, extensible API which provides utility on top of Android's normal Log class.

## Extras

#### CI-Pipeline

[GitHub Actions](https://github.com/features/actions) is used for Continuous Integration every time an update is made
to the repo. The work flows build the project and ensure that code quality is maintained using kLint. The work
is set to run once a PR is opened

#### To come

The project will include the ROOM DB because that is also part of the common pattern in modern Android
Development. The usage of Kotlin DSL would also be a nice addition.
 This will also come with other tests but the available ones are enough for now. However,
feel free to open a PR if you feel that the project has room for improvement

```
   Copyright 2020 Ferdinand Bada

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
