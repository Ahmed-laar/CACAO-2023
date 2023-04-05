# Errors on Push 
## Rejected - non-fast-forward 

1. Commit your changes.
2. Pull the changes from your team repository.
3. Resolve conflicts if needed.
4. Commit and push.

# Errors on Pull

## Checkout conflict or DIRTY_WORKTREE
You have a local change that you did not commit. 
You can 1) commit without pushing you local change or 2) delete your local change by replacing the changed files/folders with a previous version.
Then you will be able to pull. This will maybe result in a conflict, if your colleagues changed the same lines.
After resolving the conflict, commit all changed files and push.

# Problems of Pull Requests

## "This branch is out-of-date with the base branch"

Your team repository is not up-to-date with the changes that happened on the main repository. Please pull from the main repository and then push to the team repository.

## "Code owner review required"
You are changing files outside of your java package. You can see the files that you are changing in the "Files changed" tab of your pull request on the github website. This list must contain only files in your package.

You can replace these files with the version from the main repository. To do that, right click on these files or folders -> Replace with -> Branch, Tag or Reference -> Remote tracking -> select the main repository (not your team repository) -> Replace. Then commit and push to your repository. Don't close the pull request, it will be automatically updated.

Note that if the files you changed are not Java files, they will be hidden in the Java perspective of Eclipse. To see and edit them, switch to the Resource perspective of Eclipse.

## Additions outside of the package

In the Resource perspective you can replace all folders and files (including hidden files). Since there is no .metadata folder in the main repository, you don't have anything to replace it with. You can simply delete it.

## Compilation error
Your code has a compilation error (red mark in Eclipse). You can read the error message by clicking on "Details" near to the failed test at the bottom of your pull request. Please fix it and commit+push again.

## Execution error
Not accepting because the code does not pass the tests. You can run the same tests on your Eclipse, they are `test/abstraction/FiliereParDefaultTest.java` and `test/presentation/FenetrePrincipaleTest.java`. To run them right-click on "build.xml", Run As -> Ant Build. You will see the error message in the console.

## Correcting the pull request
No need to close and reopen the pull request, you can just fix the problems and push to your repository.
