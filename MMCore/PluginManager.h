///////////////////////////////////////////////////////////////////////////////
// FILE:          PluginManager.h
// PROJECT:       Micro-Manager
// SUBSYSTEM:     MMCore
//-----------------------------------------------------------------------------
// DESCRIPTION:   Loading/unloading of plugins(module libraries) and creation
//                of devices.
//              
// COPYRIGHT:     University of California, San Francisco, 2006,
//                All Rights reserved
//
// LICENSE:       This file is distributed under the "Lesser GPL" (LGPL) license.
//                License text is included with the source distribution.
//
//                This file is distributed in the hope that it will be useful,
//                but WITHOUT ANY WARRANTY; without even the implied warranty
//                of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
//
//                IN NO EVENT SHALL THE COPYRIGHT OWNER OR
//                CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
//                INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES.
//
// AUTHOR:        Nenad Amodaj, nenad@amodaj.com, 08/10/2005

#ifndef _PLUGIN_MANAGER_H_
#define _PLUGIN_MANAGER_H_

#ifdef WIN32
// disable exception scpecification warnings in MSVC
#pragma warning( disable : 4290 )
#endif

#include "LoadableModules/LoadedDeviceAdapter.h"

#include <string>
#include <cstring>
#include <vector>
#include <map>
#include <set>
#include "../MMDevice/MMDeviceConstants.h"
#include "../MMDevice/MMDevice.h"
#include "../MMDevice/DeviceThreads.h"
#include "ErrorCodes.h"
#include "Error.h"

/**
 * Manages the device collection. Responsible for handling plugin libraries
 * and device construction and destruction
 */
class CPluginManager
{
public:

	CPluginManager();
	virtual ~CPluginManager();
   
   MM::Device* LoadDevice(const char* label, const char* moduleName, const char* deviceName);
   void UnloadDevice(MM::Device* device);
   void UnloadAllDevices();
   MM::Device* GetDevice(const std::string& label) const throw (CMMError);
   std::string GetDeviceLabel(const MM::Device& device) const;
   std::vector<std::string> GetDeviceList(MM::DeviceType t = MM::AnyType) const;
   std::vector<std::string> GetLoadedPeripherals(const char* hubLabel) const;
   MM::Hub* GetParentDevice(const MM::Device& dev) const;
   void UnloadPluginLibrary(const char* moduleName);

   // device browsing support
   static void AddSearchPath(std::string path);
   static std::vector<std::string> GetModules();
   static std::vector<std::string> GetAvailableDevices(const char* moduleName) throw (CMMError);
   static std::vector<std::string> GetAvailableDeviceDescriptions(const char* moduleName) throw (CMMError);
   static std::vector<long> GetAvailableDeviceTypes(const char* moduleName) throw (CMMError);

   // module level thread locking
   MMThreadLock* getModuleLock(const MM::Device* pDev);
   bool removeModuleLock(const char* moduleName);

private:
   static void GetModules(std::vector<std::string> &modules, const char *path);
   static boost::shared_ptr<LoadedDeviceAdapter> LoadPluginLibrary(const char* libName);
   static std::string FindInSearchPath(std::string filename);

   typedef std::map<std::string, MM::Device*> CDeviceMap;
   typedef std::vector<MM::Device*> DeviceVector;

   // some fields are static so that the static methods can use them
   static std::vector<std::string> searchPaths_;
   CDeviceMap devices_;
   DeviceVector devVector_;
   static std::map< std::string, boost::shared_ptr<LoadedDeviceAdapter> > moduleMap_;

   // This is a temporary kludge. I've factored out LoadedDeviceAdapter from
   // PluginManager, but can't store a shared_ptr in MM::Device, so I need a
   // way to get the module from the device ptr, until we have a wrapper class
   // for attached ("loaded") devices. - Mark
   std::map< const MM::Device*, boost::shared_ptr<LoadedDeviceAdapter> > deviceModules_;
};

#endif //_PLUGIN_MANAGER_H_
