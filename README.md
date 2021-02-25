# Atom Assignment App

## Download APK

APK available here: [APK Link](https://github.com/kshitij2k17atom/AtomAssignment/releases/download/1.0.0/app-release.apk)

This repository contains the assignment app for Atom.

Technologies used:

- ViewModel
- LiveData
- Navigation Component
- Dagger
- Material Components
- Kotlin Coroutines
- Firebase SDK

## Project Components

- Login
- Registration
- Home
- Redirection

## Flow

1. App always starts on the `RedirectFragment`. If the user is already authenticated, they are navigated to `HomeFragment`. If not, they are navigated to `LoginFragment`.
2. `LoginFragment` allows the user to login using a Google Account. This login-functionality is linked to a Firebase Backend.
3. If the user chooses to continue as a guest, they are redirected to `RegistrationFragment`. `RegistrationFragment` implements dummy registration, where the user enters their name and can then proceed to `HomeFragment`.

## Notes

- Authentication status is persisted across restarts using Firebase Auth
- Application supports both Light and Dark themes
