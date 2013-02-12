/**
 * @file    SBMLExtensionRegistry.h
 * @brief   Definition of SBMLExtensionRegistry, the registry class in which
 *          extension packages are registered.
 * @author  Akiya Jouraku
 *
 *
 * <!--------------------------------------------------------------------------
 * This file is part of libSBML.  Please visit http://sbml.org for more
 * information about SBML, and the latest version of libSBML.
 *
 * Copyright (C) 2009-2013 jointly by the following organizations: 
 *     1. California Institute of Technology, Pasadena, CA, USA
 *     2. EMBL European Bioinformatics Institute (EBML-EBI), Hinxton, UK
 *  
 * Copyright (C) 2006-2008 by the California Institute of Technology,
 *     Pasadena, CA, USA 
 *  
 * Copyright (C) 2002-2005 jointly by the following organizations: 
 *     1. California Institute of Technology, Pasadena, CA, USA
 *     2. Japan Science and Technology Agency, Japan
 * 
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation.  A copy of the license agreement is provided
 * in the file named "LICENSE.txt" included with this software distribution
 * and also available online as http://sbml.org/software/libsbml/license.html
 * ------------------------------------------------------------------------ -->
 */

#ifndef SBMLExtensionRegistry_h
#define SBMLExtensionRegistry_h

#include <sbml/extension/SBMLExtension.h>
LIBSBML_CPP_NAMESPACE_BEGIN


#ifdef __cplusplus

#include <list>
#include <map>

/**
 * @ingroup Core
 */
class LIBSBML_EXTERN SBMLExtensionRegistry
{
public:

#ifndef SWIG
  /** @cond doxygen-libsbml-internal */

  //
  // typedef for SBasePluginCreatorBase
  //
  typedef std::multimap<SBaseExtensionPoint, const SBasePluginCreatorBase*> SBasePluginMap;
  typedef std::pair<SBaseExtensionPoint, const SBasePluginCreatorBase*>     SBasePluginPair;
  typedef SBasePluginMap::iterator                                          SBasePluginMapIter;

  //
  // typedef for SBMLExtension
  //
  typedef std::map<std::string, const SBMLExtension*>              SBMLExtensionMap;
  typedef std::pair<std::string, const SBMLExtension*>             SBMLExtensionPair;
  typedef SBMLExtensionMap::iterator                               SBMLExtensionMapIter;
#endif //SWIG

  /**
   *
   * Returns an instance (singleton) of the SBMLExtensionRegistry class.
   * This function needs to be invoked when manipulating the SBMLExtensionRegistry class. 
   *
   * @return the instance of the SBMLExtensionRegistry object.
   */ 
  static SBMLExtensionRegistry& getInstance();


  /**
   * Add the given SBMLExtension to this SBMLExtensionRegistry.
   *
   * @param ext the SBMLExtension object to be added.
   *   
   * @return integer value indicating success/failure of the
   * function.  The possible values returned by this function are:
   * @li @link OperationReturnValues_t#LIBSBML_OPERATION_SUCCESS LIBSBML_OPERATION_SUCCESS @endlink
   * @li @link OperationReturnValues_t#LIBSBML_PKG_CONFLICT LIBSBML_PKG_CONFLICT @endlink
   * @li @link OperationReturnValues_t#LIBSBML_INVALID_ATTRIBUTE_VALUE LIBSBML_INVALID_ATTRIBUTE_VALUE @endlink
   */
  int addExtension (const SBMLExtension* ext);


  /**
   * Returns an SBMLExtension object with the given package URI or package name (string).
   *
   * @param package the URI or name of the package extension
   *
   * @return a clone of the SBMLExtension object with the given package URI or name. The returned 
   *         extension is to be freed (i.e.: deleted) by the caller!
   */
  SBMLExtension* getExtension(const std::string& package);

  /**
   * Remove all L2 Extension namespaces from the namespace list. This will call all 
   * overriden SBMLExtension::removeL2Namespaces methods.
   */
  void removeL2Namespaces(XMLNamespaces *xmlns) const;

  /**
   * adds all L2 Extension namespaces to the namespace list. This will call all 
   * overriden SBMLExtension::addL2Namespaces methods.
   */
  void addL2Namespaces(XMLNamespaces *xmlns) const;

  /**
   * Enables all extensions that support serialization / deserialization with
   * SBML Annotations.
   */
  void enableL2NamespaceForDocument(SBMLDocument* doc)  const;

  /** 
   * Goes through all extensions in the list of plugins of the given document
   * and disables all plugins that are not being used. 
   */
  void disableUnusedPackages(SBMLDocument *doc);

  /**
   * Disables the package with the given URI / name.
   */
  static void disablePackage(const std::string& package);

  /**
   * Disables all packages with the given URI / name.
   */
  static void disablePackages(const std::vector<std::string>& packages);
  
  /**
   * @returns the status (enabled = <b>true</b>, disabled = <b>false</b> of the given package.
   */
  static bool isPackageEnabled(const std::string& package);
  
  /**
   * Enables the package with the given URI / name.
   */
  static void enablePackage(const std::string& package);
  
  /**
   * Enables all packages with the given URI / name.
   */
  static void enablePackages(const std::vector<std::string>& packages);
  
private:
  /**
   * Returns an SBMLExtension object with the given package URI or package name (string).
   *
   * @param package the URI or name of the package extension
   *
   * @return the SBMLExtension object with the given package URI or name. The returned 
   *         extension is NOT ALLOWED to be freed (i.e.: deleted)!
   */
  const SBMLExtension* getExtensionInternal(const std::string& package);

public:

#ifndef SWIG

  /**
   * Returns the list of SBasePluginCreators with the given extension point.
   *
   * @param extPoint the SBaseExtensionPoint
   *
   * @return the list of SBasePluginCreators with the given typecode.
   */
  std::list<const SBasePluginCreatorBase*> getSBasePluginCreators(const SBaseExtensionPoint& extPoint);


  /**
   * Returns the list of SBasePluginCreators with the given URI
   * of package extension.
   *
   * @param uri the URI of the target package extension.
   *
   * @return the list of SBasePluginCreators with the given URI
   * of package extension.
   */
  std::list<const SBasePluginCreatorBase*> getSBasePluginCreators(const std::string& uri);
	             

  /**
   * Returns an SBasePluginCreator object with the combination of the given 
   * extension point and URI of the package extension.
   *
   * @param extPoint the SBaseExtensionPoint
   * @param uri the URI of the target package extension.
   *
   * @return the SBasePluginCreator with the combination of the given 
   * SBMLTypeCode_t and the given URI of package extension.
   */
  const SBasePluginCreatorBase* getSBasePluginCreator(const SBaseExtensionPoint& extPoint,
                                                      const std::string& uri);
               
#endif //SWIG

  /**
   * Returns the number of SBMLExtension* with the given extension point.
   *
   * @param extPoint the SBaseExtensionPoint
   *
   * @return the number of SBMLExtension* with the given extension point.
   */
  unsigned int getNumExtension(const SBaseExtensionPoint& extPoint);


  /**
   * Enable/disable the package with the given uri.
   *
   * @param uri the URI of the target package.
   * @param isEnabled the bool value corresponding to enabled (true) or 
   * disabled (false)
   *
   * @return false will be returned if the given bool value is false 
   * or the given package is not registered, otherwise true will be
   * returned.
   */
  bool
  setEnabled(const std::string& uri, bool isEnabled);
  

  /**
   * Checks if the extension with the given URI is enabled (true) or 
   * disabled (false)
   *
   * @param uri the URI of the target package.
   *
   * @return false will be returned if the given package is disabled 
   * or not registered, otherwise true will be returned.
   */
  bool isEnabled(const std::string& uri);


  /**
   * Checks if the extension with the given URI is registered (true) 
   * or not (false)
   *
   * @param uri the URI of the target package.
   *
   * @return true will be returned if the package with the given URI
   * is registered, otherwise false will be returned.
   */
  bool isRegistered(const std::string& uri);


  /** 
   * Returns a list of registered packages (such as 'layout', 'fbc' or 'comp')
   * the list contains char* strings and has to be freed by the caller. 
   * 
   * @return the names of the registered packages in a list
   */
  static List* getRegisteredPackageNames();

  /** 
   * Returns the number of registered packages.
   * 
   * @return the number of registered packages.
   */
  static unsigned int getNumRegisteredPackages();


  /** 
   * Returns the registered package name at the given index
   * 
   * @param index zero based index of the package name to return
   * 
   * @return the package name with the given index or NULL
   */
  static std::string getRegisteredPackageName(unsigned int index);

private:

  //
  // Constructor and Copy constructor must not be overridden.
  //
  SBMLExtensionRegistry();
  SBMLExtensionRegistry(const SBMLExtensionRegistry& orig);
  
  static bool registered;

  /** @cond doxygen-libsbml-internal */
 
  SBMLExtensionMap  mSBMLExtensionMap;
  SBasePluginMap    mSBasePluginMap;

  //
  // Allow getExtensionInternal to be used from within libsbml. 
  //
  friend class SBMLTypeCodes;
  friend class SBMLNamespaces;
  friend class SBMLDocument;
  friend class SBasePlugin;
  friend class SBase;
  template <class SBMLExtensionType> friend class SBMLExtensionNamespaces;
  template<class SBasePluginType, class SBMLExtensionType> friend class SBasePluginCreator;

  /** @endcond */
};

LIBSBML_CPP_NAMESPACE_END

#endif  /* __cplusplus */

#ifndef SWIG

LIBSBML_CPP_NAMESPACE_BEGIN
BEGIN_C_DECLS

LIBSBML_EXTERN
int 
SBMLExtensionRegistry_addExtension(const SBMLExtension_t* extension);

LIBSBML_EXTERN
SBMLExtension_t* 
SBMLExtensionRegistry_getExtension(const char* package);

LIBSBML_EXTERN
const SBasePluginCreatorBase_t* 
SBMLExtensionRegistry_getSBasePluginCreator(const SBaseExtensionPoint_t* extPoint, const char* uri);

LIBSBML_EXTERN
SBasePluginCreatorBase_t**
SBMLExtensionRegistry_getSBasePluginCreators(const SBaseExtensionPoint_t* extPoint, int* length);

LIBSBML_EXTERN
SBasePluginCreatorBase_t**
SBMLExtensionRegistry_getSBasePluginCreatorsByURI(const char* uri, int* length);


LIBSBML_EXTERN
int
SBMLExtensionRegistry_isEnabled(const char* uri);

LIBSBML_EXTERN
int
SBMLExtensionRegistry_setEnabled(const char* uri, int isEnabled);


LIBSBML_EXTERN
int
SBMLExtensionRegistry_isRegistered(const char* uri);


LIBSBML_EXTERN
int 
SBMLExtensionRegistry_getNumExtensions(const SBaseExtensionPoint_t* extPoint);

LIBSBML_EXTERN
List_t*
SBMLExtensionRegistry_getRegisteredPackages();

END_C_DECLS
LIBSBML_CPP_NAMESPACE_END

#endif  /* !SWIG */

#endif  /* SBMLExtensionRegistry_h */

