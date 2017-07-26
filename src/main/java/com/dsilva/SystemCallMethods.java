package com.dsilva;

/**
 * Created by Himasha on 7/27/2017.
 */
public interface SystemCallMethods {

    public String getHelp();

    public String getTotalMemory();

    public String getFreeMemory();

    public String getUsedMemory();

    public String getOSName();

    public String getOSVersion();

    public String getOSArchitecture();

    public String getAvailableProcessors();

    public String getIP();

    public void printHardDiskDetails();

}
