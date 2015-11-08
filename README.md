Grails basics
-----------------
Grails has a 'convention over configration' approach and so expects different parts of the system to appear in defined
places in the codebase

The basic structure is as follows

root
|
 -> grails-app
|       |
|        -> conf : build, startup and spring configuration
|        -> controllers : server side business logic. This is the 'C' in MVC.
|        -> domain : database entities. Uses GORM for configuration but also works with Hibernate JPA annotations
|        -> i18n : internationalisation properties
|        -> taglib : help logic for use in views
|        -> views : html 'views'. The convention here is that the directory the view is in relates to the controller
|                   that holds the business logic. I.e user/index.gsp is the view for the index method (known as an action)
|                   in the UserController controller.
|
 -> web-app
      |
       -> css : style sheet code
       -> images
       -> js : javascript



Download grails v2.3.11 from:
   https://github-cloud.s3.amazonaws.com/releases/512295/4eac2b22-9d89-11e4-97ea-fbb8ff8113ff.zip?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAISTNZFOVBIJMK3TQ%2F20151106%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20151106T171604Z&X-Amz-Expires=300&X-Amz-Signature=ec8fdd86b71f42bd3e3f559d717e5a470d819bbeef340d6e4059fd6979f87c4b&X-Amz-SignedHeaders=host&actor_id=0&response-content-disposition=attachment%3B%20filename%3Dgrails-2.3.11.zip&response-content-type=application%2Foctet-stream

To start base app:
  (In Intelij Idea) : choose 'validis-reports' in run configurations and click run
  (from cmd line) : add <grails_installation>/bin to path and then run 'run-app' from the root of the project
