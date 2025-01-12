# Profilling (which Env should Active) 

- define one Controller which in which we are returning some message over here [ProfileController.java](main/java/com/selfGroup/firstEmpCrud/Controller/ProfileController.java)
- write different env file 
- follow conventional names like ``application-<env>.properties`` 

  - now go in the main properties file which is ``application.properties`` 
  - set one variable ``spring.profile.active=<env>``