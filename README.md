# SystemInfo

SystemInfo can be use to check system informations of PC. eg- Total/free/used physical memory,
OS information like name,version,architecture,available processors etc.

Build :
  1. clone the repository
  2. mvn clean install
  
To Run :
  1.SystemInfo -<option>
  
  options : help, m, fm ,hd ,os, ip etc.
  
  ex1: SystemInfor -help
    usage: java SystemInfo [options]
    -m      Show total memory
    -fm     Show free memory
    -um     Show used memory
    -os     Show OS info
    -ip     Show IP address
    -hd     Show HardDisk Details
    
   ex2: SystemInfo -os
    OS name :               Windows 10
    OS version :            10.0
    OS architecture :       amd64
    Available processors :  4
      
