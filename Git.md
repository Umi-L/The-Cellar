# Git
git is a version control software that we will be using for this project.

## Quick Start
```
git clone
git add .
git commit -m "message"
git push
```

## Installation
https://git-scm.com/

## Usage
### setup
Setup your username and email for git
```
git config --global user.name "Julian O'Grady"
git config --global user.email "julian@example.com"
```

### clone
Clone the repository to your local machine (most likely your eclipse workspace)
```
git clone https://github.com/Umi-L/The-Cellar.git
```

## usage (basic)
There are 4 major commands we will be using in this project
```
git add <file> // add a file to the staging area
git commit -m "message" // commit the staged files to the local repository
git push // push the local repository to the remote repository
git pull // pull the remote repository to the local repository
```

### git add
git add is used to add files to be committed. Likely in all of your use cases it will be used like this:
```
git add .
```
this will add all files to be committed.

### git commit
git commit is used to commit the staged files to the local repository. Likely in all of your use cases it will be used like this:
```
git commit -m "INSERT A MESSAGE HERE"
```
this will commit the staged files to the local repository with the message in this case "INSERT A MESSAGE HERE"
this message will depend on what you're doing. In most cases it should be a quick few word summary of what you did.

### git push
git push is used to push the local repository to the remote repository. Likely in all of your use cases it will be used like this:
```
git push
```
This will push your local changes to the repository for everyone else to see.

### git pull
git pull is used to pull the remote repository to the local repository. Likely in all of your use cases it will be used like this:
```
git pull
```
This will pull the remote changes to the repository for you to see. Every time someone makes a change you will want to run this command.

## For Mac
on mac you may need to install xcode command line tools
https://developer.apple.com/forums/thread/677124

## For Windows on a School Computer
You want to install git standalone and install it somewhere on your student folder
https://git-scm.com/download/win
You will likely need to start "git-bash" every time you want to use git.

## For Windows on a Personal Computer
You want to install the NON stand alone version of git and install it somewhere on your computer
https://git-scm.com/download/win

## usage from eclipse
To open the command line in eclipse you need to right click on the project and click show in local terminal -> git bash

## basic command line commands
```
ls // list files in the current directory
cd <directory> // change directory
cd .. // go up a directory
```