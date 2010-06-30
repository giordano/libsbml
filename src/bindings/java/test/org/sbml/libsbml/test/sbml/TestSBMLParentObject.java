/*
 *
 * @file    TestSBMLParentObject.java
 * @brief   SBML parent object unit tests
 *
 * @author  Akiya Jouraku (Java conversion)
 * @author  Sarah Keating 
 *
 * $Id$
 * $HeadURL$
 *
 * This test file was converted from src/sbml/test/TestSBMLParentObject.cpp
 * with the help of conversion sciprt (ctest_converter.pl).
 *
 *<!---------------------------------------------------------------------------
 * This file is part of libSBML.  Please visit http://sbml.org for more
 * information about SBML, and the latest version of libSBML.
 *
 * Copyright 2005-2010 California Institute of Technology.
 * Copyright 2002-2005 California Institute of Technology and
 *                     Japan Science and Technology Corporation.
 * 
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation.  A copy of the license agreement is provided
 * in the file named "LICENSE.txt" included with this software distribution
 * and also available online as http://sbml.org/software/libsbml/license.html
 *--------------------------------------------------------------------------->*/


package org.sbml.libsbml.test.sbml;

import org.sbml.libsbml.*;

import java.io.File;
import java.lang.AssertionError;

public class TestSBMLParentObject {

  static void assertTrue(boolean condition) throws AssertionError
  {
    if (condition == true)
    {
      return;
    }
    throw new AssertionError();
  }

  static void assertEquals(Object a, Object b) throws AssertionError
  {
    if ( (a == null) && (b == null) )
    {
      return;
    }
    else if ( (a == null) || (b == null) )
    {
      throw new AssertionError();
    }
    else if (a.equals(b))
    {
      return;
    }

    throw new AssertionError();
  }

  static void assertNotEquals(Object a, Object b) throws AssertionError
  {
    if ( (a == null) && (b == null) )
    {
      throw new AssertionError();
    }
    else if ( (a == null) || (b == null) )
    {
      return;
    }
    else if (a.equals(b))
    {
      throw new AssertionError();
    }
  }

  static void assertEquals(boolean a, boolean b) throws AssertionError
  {
    if ( a == b )
    {
      return;
    }
    throw new AssertionError();
  }

  static void assertNotEquals(boolean a, boolean b) throws AssertionError
  {
    if ( a != b )
    {
      return;
    }
    throw new AssertionError();
  }

  static void assertEquals(int a, int b) throws AssertionError
  {
    if ( a == b )
    {
      return;
    }
    throw new AssertionError();
  }

  static void assertNotEquals(int a, int b) throws AssertionError
  {
    if ( a != b )
    {
      return;
    }
    throw new AssertionError();
  }

  public void test_AlgebraicRule_parent_create()
  {
    Model m = new Model(2,4);
    AlgebraicRule r = m.createAlgebraicRule();
    ListOf lo = m.getListOfRules();
    assertTrue( lo.equals(m.getRule(0).getParentSBMLObject()) );
    assertTrue( lo.equals(r.getParentSBMLObject()) );
    assertTrue( m.equals(lo.getParentSBMLObject()) );
  }

  public void test_AssignmentRule_parent_create()
  {
    Model m = new Model(2,4);
    AssignmentRule r = m.createAssignmentRule();
    ListOf lo = m.getListOfRules();
    assertTrue( lo.equals(m.getRule(0).getParentSBMLObject()) );
    assertTrue( lo.equals(r.getParentSBMLObject()) );
    assertTrue( m.equals(lo.getParentSBMLObject()) );
  }

  public void test_CompartmentType_parent_NULL()
  {
    SBMLDocument d = new SBMLDocument(2,4);
    Model m = d.createModel();
    CompartmentType c = m.createCompartmentType();
    CompartmentType c1 = c.cloneObject();
    d = null;
    assertTrue( c1.getAncestorOfType(libsbml.SBML_MODEL) == null );
    assertTrue( c1.getParentSBMLObject() == null );
    assertEquals(c1.getSBMLDocument(),null);
    c1 = null;
  }

  public void test_CompartmentType_parent_add()
  {
    CompartmentType ct = new CompartmentType(2,4);
    Model m = new Model(2,4);
    ct.setId("ct");
    m.addCompartmentType(ct);
    ct = null;
    ListOf lo = m.getListOfCompartmentTypes();
    assertTrue( lo.equals(m.getCompartmentType(0).getParentSBMLObject()) );
    assertTrue( m.equals(lo.getParentSBMLObject()) );
  }

  public void test_CompartmentType_parent_create()
  {
    Model m = new Model(2,4);
    CompartmentType ct = m.createCompartmentType();
    ListOf lo = m.getListOfCompartmentTypes();
    assertTrue( lo.equals(m.getCompartmentType(0).getParentSBMLObject()) );
    assertTrue( lo.equals(ct.getParentSBMLObject()) );
    assertTrue( m.equals(lo.getParentSBMLObject()) );
  }

  public void test_Compartment_parent_NULL()
  {
    SBMLDocument d = new SBMLDocument();
    Model m = d.createModel();
    Compartment c = m.createCompartment();
    Compartment c1 = c.cloneObject();
    d = null;
    assertTrue( c1.getAncestorOfType(libsbml.SBML_MODEL) == null );
    assertTrue( c1.getParentSBMLObject() == null );
    assertEquals(c1.getSBMLDocument(),null);
    c1 = null;
  }

  public void test_Compartment_parent_add()
  {
    Compartment c = new Compartment(2,4);
    c.setId("c");
    Model m = new Model(2,4);
    m.addCompartment(c);
    c = null;
    ListOf lo = m.getListOfCompartments();
    assertTrue( lo.equals(m.getCompartment(0).getParentSBMLObject()) );
    assertTrue( m.equals(lo.getParentSBMLObject()) );
  }

  public void test_Compartment_parent_create()
  {
    Model m = new Model(2,4);
    Compartment c = m.createCompartment();
    ListOf lo = m.getListOfCompartments();
    assertTrue( lo.equals(m.getCompartment(0).getParentSBMLObject()) );
    assertTrue( lo.equals(c.getParentSBMLObject()) );
    assertTrue( m.equals(lo.getParentSBMLObject()) );
  }

  public void test_Constraint_parent_NULL()
  {
    SBMLDocument d = new SBMLDocument();
    Model m = d.createModel();
    Constraint c = m.createConstraint();
    Constraint c1 = c.cloneObject();
    d = null;
    assertTrue( c1.getAncestorOfType(libsbml.SBML_MODEL) == null );
    assertTrue( c1.getParentSBMLObject() == null );
    assertEquals(c1.getSBMLDocument(),null);
    c1 = null;
  }

  public void test_Constraint_parent_add()
  {
    Constraint ct = new Constraint(2,4);
    Model m = new Model(2,4);
    ct.setMath(libsbml.parseFormula("a-k"));
    m.addConstraint(ct);
    ct = null;
    ListOf lo = m.getListOfConstraints();
    assertTrue( lo.equals(m.getConstraint(0).getParentSBMLObject()) );
    assertTrue( m.equals(lo.getParentSBMLObject()) );
  }

  public void test_Constraint_parent_create()
  {
    Model m = new Model(2,4);
    Constraint ct = m.createConstraint();
    ListOf lo = m.getListOfConstraints();
    assertTrue( lo.equals(m.getConstraint(0).getParentSBMLObject()) );
    assertTrue( lo.equals(ct.getParentSBMLObject()) );
    assertTrue( m.equals(lo.getParentSBMLObject()) );
  }

  public void test_Delay_parent_add()
  {
    Delay d = new Delay(2,4);
    Event e = new Event(2,4);
    e.setDelay(d);
    d = null;
    assertTrue( e.equals(e.getDelay().getParentSBMLObject()) );
    e = null;
  }

  public void test_EventAssignment_parent_add()
  {
    Event e = new Event(2,4);
    EventAssignment ea = new EventAssignment(2,4);
    ea.setVariable("c");
    ea.setMath(libsbml.parseFormula("K+L"));
    e.addEventAssignment(ea);
    ea = null;
    ListOf lo = e.getListOfEventAssignments();
    assertTrue( lo.equals(e.getEventAssignment(0).getParentSBMLObject()) );
    assertTrue( e.equals(lo.getParentSBMLObject()) );
  }

  public void test_EventAssignment_parent_create()
  {
    Event e = new Event(2,4);
    EventAssignment ea = e.createEventAssignment();
    ListOf lo = e.getListOfEventAssignments();
    assertTrue( lo.equals(e.getEventAssignment(0).getParentSBMLObject()) );
    assertTrue( lo.equals(ea.getParentSBMLObject()) );
    assertTrue( e.equals(lo.getParentSBMLObject()) );
  }

  public void test_EventAssignment_parent_create_model()
  {
    Model m = new Model(2,4);
    Event e = m.createEvent();
    EventAssignment ea = m.createEventAssignment();
    ListOf lo = e.getListOfEventAssignments();
    assertTrue( lo.equals(e.getEventAssignment(0).getParentSBMLObject()) );
    assertTrue( lo.equals(ea.getParentSBMLObject()) );
    assertTrue( e.equals(lo.getParentSBMLObject()) );
  }

  public void test_Event_parent_NULL()
  {
    SBMLDocument d = new SBMLDocument(2,4);
    Model m = d.createModel();
    Event c = m.createEvent();
    EventAssignment ea = c.createEventAssignment();
    Trigger t = new Trigger(2,4);
    t.setMath(new ASTNode());
    Delay dy = new Delay(2,4);
    dy.setMath(new ASTNode());
    c.setTrigger(t);
    c.setDelay(dy);
    assertTrue( c.getAncestorOfType(libsbml.SBML_MODEL).equals(m) );
    assertTrue( c.getTrigger().getParentSBMLObject().equals(c) );
    assertEquals(c.getDelay().getSBMLDocument(),d);
    assertTrue( ea.getAncestorOfType(libsbml.SBML_EVENT).equals(c) );
    Event c1 = c.cloneObject();
    d = null;
    assertTrue( c1.getAncestorOfType(libsbml.SBML_MODEL) == null );
    assertTrue( c1.getParentSBMLObject() == null );
    assertEquals(c1.getSBMLDocument(),null);
    assertTrue( c1.getEventAssignment(0).getAncestorOfType(libsbml.SBML_MODEL) == null );
    assertTrue( c1.getEventAssignment(0).getAncestorOfType(libsbml.SBML_EVENT).equals(c1) );
    assertTrue( c1.getEventAssignment(0).getParentSBMLObject() != null );
    assertEquals(c1.getEventAssignment(0).getSBMLDocument(),null);
    assertTrue( c1.getTrigger().getAncestorOfType(libsbml.SBML_MODEL) == null );
    assertTrue( c1.getTrigger().getAncestorOfType(libsbml.SBML_EVENT).equals(c1) );
    assertTrue( c1.getTrigger().getParentSBMLObject() != null );
    assertEquals(c1.getTrigger().getSBMLDocument(),null);
    assertTrue( c1.getDelay().getAncestorOfType(libsbml.SBML_MODEL) == null );
    assertTrue( c1.getDelay().getAncestorOfType(libsbml.SBML_EVENT).equals(c1) );
    assertTrue( c1.getDelay().getParentSBMLObject() != null );
    assertEquals(c1.getDelay().getSBMLDocument(),null);
    c1 = null;
  }

  public void test_Event_parent_add()
  {
    Event e = new Event(2,4);
    Trigger t = new Trigger(2,4);
    e.setTrigger(t);
    e.createEventAssignment();
    Model m = new Model(2,4);
    m.addEvent(e);
    e = null;
    ListOf lo = m.getListOfEvents();
    assertTrue( lo.equals(m.getEvent(0).getParentSBMLObject()) );
    assertTrue( m.equals(lo.getParentSBMLObject()) );
  }

  public void test_Event_parent_create()
  {
    Model m = new Model(2,4);
    Event e = m.createEvent();
    ListOf lo = m.getListOfEvents();
    assertTrue( lo.equals(m.getEvent(0).getParentSBMLObject()) );
    assertTrue( lo.equals(e.getParentSBMLObject()) );
    assertTrue( m.equals(lo.getParentSBMLObject()) );
  }

  public void test_FunctionDefinition_parent_NULL()
  {
    SBMLDocument d = new SBMLDocument();
    Model m = d.createModel();
    FunctionDefinition c = m.createFunctionDefinition();
    FunctionDefinition c1 = c.cloneObject();
    d = null;
    assertTrue( c1.getAncestorOfType(libsbml.SBML_MODEL) == null );
    assertTrue( c1.getParentSBMLObject() == null );
    assertEquals(c1.getSBMLDocument(),null);
    c1 = null;
  }

  public void test_FunctionDefinition_parent_add()
  {
    FunctionDefinition fd = new FunctionDefinition(2,4);
    Model m = new Model(2,4);
    fd.setId("fd");
    fd.setMath(libsbml.parseFormula("l"));
    m.addFunctionDefinition(fd);
    fd = null;
    ListOf lo = m.getListOfFunctionDefinitions();
    assertTrue( lo.equals(m.getFunctionDefinition(0).getParentSBMLObject()) );
    assertTrue( m.equals(lo.getParentSBMLObject()) );
  }

  public void test_FunctionDefinition_parent_create()
  {
    Model m = new Model(2,4);
    FunctionDefinition fd = m.createFunctionDefinition();
    ListOf lo = m.getListOfFunctionDefinitions();
    assertTrue( lo.equals(m.getFunctionDefinition(0).getParentSBMLObject()) );
    assertTrue( lo.equals(fd.getParentSBMLObject()) );
    assertTrue( m.equals(lo.getParentSBMLObject()) );
  }

  public void test_InitialAssignment_parent_NULL()
  {
    SBMLDocument d = new SBMLDocument();
    Model m = d.createModel();
    InitialAssignment c = m.createInitialAssignment();
    InitialAssignment c1 = c.cloneObject();
    d = null;
    assertTrue( c1.getAncestorOfType(libsbml.SBML_MODEL) == null );
    assertTrue( c1.getParentSBMLObject() == null );
    assertEquals(c1.getSBMLDocument(),null);
    c1 = null;
  }

  public void test_InitialAssignment_parent_add()
  {
    InitialAssignment ia = new InitialAssignment(2,4);
    Model m = new Model(2,4);
    ia.setSymbol("c");
    ia.setMath(libsbml.parseFormula("9"));
    m.addInitialAssignment(ia);
    ia = null;
    ListOf lo = m.getListOfInitialAssignments();
    assertTrue( lo.equals(m.getInitialAssignment(0).getParentSBMLObject()) );
    assertTrue( m.equals(lo.getParentSBMLObject()) );
  }

  public void test_InitialAssignment_parent_create()
  {
    Model m = new Model(2,4);
    InitialAssignment ia = m.createInitialAssignment();
    ListOf lo = m.getListOfInitialAssignments();
    assertTrue( lo.equals(m.getInitialAssignment(0).getParentSBMLObject()) );
    assertTrue( lo.equals(ia.getParentSBMLObject()) );
    assertTrue( m.equals(lo.getParentSBMLObject()) );
  }

  public void test_KineticLaw_Parameter_parent_add()
  {
    KineticLaw kl = new KineticLaw(2,4);
    Parameter p = new Parameter(2,4);
    p.setId("jake");
    kl.addParameter(p);
    p = null;
    assertTrue( kl.getNumParameters() == 1 );
    assertTrue( kl.getParameter(0).getId().equals( "jake") );
    ListOfParameters lop = kl.getListOfParameters();
    assertTrue( kl.equals(lop.getParentSBMLObject()) );
    assertTrue( lop.equals(kl.getParameter(0).getParentSBMLObject()) );
    kl = null;
  }

  public void test_KineticLaw_Parameter_parent_create()
  {
    KineticLaw kl = new KineticLaw(2,4);
    Parameter p = kl.createParameter();
    assertTrue( kl.getNumParameters() == 1 );
    ListOfParameters lop = kl.getListOfParameters();
    assertTrue( kl.equals(lop.getParentSBMLObject()) );
    assertTrue( lop.equals(p.getParentSBMLObject()) );
    assertTrue( lop.equals(kl.getParameter(0).getParentSBMLObject()) );
    kl = null;
  }

  public void test_KineticLaw_Parameter_parent_create_model()
  {
    Model m = new Model(2,4);
    Reaction r = m.createReaction();
    KineticLaw kl = m.createKineticLaw();
    Parameter p = m.createKineticLawParameter();
    assertTrue( kl.getNumParameters() == 1 );
    ListOfParameters lop = kl.getListOfParameters();
    assertTrue( r.equals(kl.getParentSBMLObject()) );
    assertTrue( kl.equals(lop.getParentSBMLObject()) );
    assertTrue( lop.equals(p.getParentSBMLObject()) );
    assertTrue( lop.equals(kl.getParameter(0).getParentSBMLObject()) );
    kl = null;
  }

  public void test_KineticLaw_parent_NULL()
  {
    Reaction r = new Reaction(2,4);
    KineticLaw kl = r.createKineticLaw();
    Parameter p = kl.createParameter();
    assertTrue( r.equals(kl.getParentSBMLObject()) );
    assertTrue( r.equals(p.getAncestorOfType(libsbml.SBML_REACTION)) );
    assertTrue( kl.equals(p.getAncestorOfType(libsbml.SBML_KINETIC_LAW)) );
    KineticLaw kl1 = kl.cloneObject();
    assertTrue( kl1.getParentSBMLObject() == null );
    assertTrue( kl1.getParameter(0).getAncestorOfType(libsbml.SBML_REACTION) == null );
    assertTrue( kl1.equals(kl1.getParameter(0).getAncestorOfType(libsbml.SBML_KINETIC_LAW)) );
    r = null;
  }

  public void test_KineticLaw_parent_add()
  {
    KineticLaw kl = new KineticLaw(2,4);
    Reaction r = new Reaction(2,4);
    r.setKineticLaw(kl);
    assertTrue( r.equals(r.getKineticLaw().getParentSBMLObject()) );
    r = null;
  }

  public void test_KineticLaw_parent_create()
  {
    Reaction r = new Reaction(2,4);
    KineticLaw kl = r.createKineticLaw();
    assertTrue( r.equals(kl.getParentSBMLObject()) );
    r = null;
  }

  public void test_KineticLaw_parent_create_model()
  {
    Model m = new Model(2,4);
    Reaction r = m.createReaction();
    KineticLaw kl = r.createKineticLaw();
    assertTrue( r.equals(kl.getParentSBMLObject()) );
    assertTrue( r.equals(r.getKineticLaw().getParentSBMLObject()) );
    r = null;
  }

  public void test_Model_parent_add()
  {
    SBMLDocument d = new SBMLDocument(2,4);
    Model m = new Model(2,4);
    d.setModel(m);
    assertTrue( d.equals(d.getModel().getParentSBMLObject()) );
    d = null;
  }

  public void test_Model_parent_create()
  {
    SBMLDocument d = new SBMLDocument(2,4);
    Model m = d.createModel();
    assertTrue( d.equals(m.getParentSBMLObject()) );
    d = null;
  }

  public void test_Parameter_parent_NULL()
  {
    SBMLDocument d = new SBMLDocument();
    Model m = d.createModel();
    Parameter c = m.createParameter();
    Parameter c1 = c.cloneObject();
    d = null;
    assertTrue( c1.getAncestorOfType(libsbml.SBML_MODEL) == null );
    assertTrue( c1.getParentSBMLObject() == null );
    assertEquals(c1.getSBMLDocument(),null);
    c1 = null;
  }

  public void test_Parameter_parent_add()
  {
    Parameter ia = new Parameter(2,4);
    Model m = new Model(2,4);
    ia.setId("p");
    m.addParameter(ia);
    ia = null;
    ListOf lo = m.getListOfParameters();
    assertTrue( lo.equals(m.getParameter(0).getParentSBMLObject()) );
    assertTrue( m.equals(lo.getParentSBMLObject()) );
  }

  public void test_Parameter_parent_create()
  {
    Model m = new Model(2,4);
    Parameter p = m.createParameter();
    ListOf lo = m.getListOfParameters();
    assertTrue( lo.equals(m.getParameter(0).getParentSBMLObject()) );
    assertTrue( lo.equals(p.getParentSBMLObject()) );
    assertTrue( m.equals(lo.getParentSBMLObject()) );
  }

  public void test_RateRule_parent_create()
  {
    Model m = new Model(2,4);
    RateRule r = m.createRateRule();
    ListOf lo = m.getListOfRules();
    assertTrue( lo.equals(m.getRule(0).getParentSBMLObject()) );
    assertTrue( lo.equals(r.getParentSBMLObject()) );
    assertTrue( m.equals(lo.getParentSBMLObject()) );
  }

  public void test_Reaction_parent_NULL()
  {
    SBMLDocument d = new SBMLDocument();
    Model m = d.createModel();
    Reaction c = m.createReaction();
    SpeciesReference sr = c.createReactant();
    KineticLaw kl = c.createKineticLaw();
    assertTrue( c.getAncestorOfType(libsbml.SBML_MODEL).equals(m) );
    assertEquals(c.getSBMLDocument(),d);
    assertTrue( sr.getAncestorOfType(libsbml.SBML_REACTION).equals(c) );
    assertTrue( kl.getAncestorOfType(libsbml.SBML_REACTION).equals(c) );
    Reaction c1 = c.cloneObject();
    d = null;
    assertTrue( c1.getAncestorOfType(libsbml.SBML_MODEL) == null );
    assertTrue( c1.getParentSBMLObject() == null );
    assertEquals(c1.getSBMLDocument(),null);
    SpeciesReference sr1 = c1.getReactant(0);
    assertTrue( sr1.getAncestorOfType(libsbml.SBML_MODEL) == null );
    assertTrue( sr1.getAncestorOfType(libsbml.SBML_REACTION).equals(c1) );
    assertEquals(sr1.getSBMLDocument(),null);
    assertTrue( c1.getKineticLaw().getAncestorOfType(libsbml.SBML_MODEL) == null );
    assertTrue( c1.getKineticLaw().getAncestorOfType(libsbml.SBML_REACTION).equals(c1) );
    assertEquals(c1.getKineticLaw().getSBMLDocument(),null);
    c1 = null;
  }

  public void test_Reaction_parent_add()
  {
    Reaction ia = new Reaction(2,4);
    Model m = new Model(2,4);
    ia.setId("k");
    m.addReaction(ia);
    ia = null;
    ListOf lo = m.getListOfReactions();
    assertTrue( lo.equals(m.getReaction(0).getParentSBMLObject()) );
    assertTrue( m.equals(lo.getParentSBMLObject()) );
  }

  public void test_Reaction_parent_create()
  {
    Model m = new Model(2,4);
    Reaction r = m.createReaction();
    ListOf lo = m.getListOfReactions();
    assertTrue( lo.equals(m.getReaction(0).getParentSBMLObject()) );
    assertTrue( lo.equals(r.getParentSBMLObject()) );
    assertTrue( m.equals(lo.getParentSBMLObject()) );
  }

  public void test_Rule_parent_add()
  {
    Rule ia = new RateRule(2,4);
    ia.setVariable("a");
    ia.setMath(libsbml.parseFormula("9"));
    Model m = new Model(2,4);
    m.addRule(ia);
    ia = null;
    ListOf lo = m.getListOfRules();
    assertTrue( lo.equals(m.getRule(0).getParentSBMLObject()) );
    assertTrue( m.equals(lo.getParentSBMLObject()) );
  }

  public void test_SpeciesReference_Modifier_parent_add()
  {
    ModifierSpeciesReference sr = new ModifierSpeciesReference(2,4);
    sr.setSpecies("s");
    Reaction r = new Reaction(2,4);
    r.addModifier(sr);
    sr = null;
    ListOf lo = r.getListOfModifiers();
    assertTrue( lo.equals(r.getModifier(0).getParentSBMLObject()) );
    assertTrue( r.equals(lo.getParentSBMLObject()) );
  }

  public void test_SpeciesReference_Modifier_parent_create()
  {
    Reaction r = new Reaction(2,4);
    ModifierSpeciesReference sr = r.createModifier();
    ListOf lo = r.getListOfModifiers();
    assertTrue( lo.equals(sr.getParentSBMLObject()) );
    assertTrue( lo.equals(r.getModifier(0).getParentSBMLObject()) );
    assertTrue( r.equals(lo.getParentSBMLObject()) );
  }

  public void test_SpeciesReference_Modifier_parent_create_model()
  {
    Model m = new Model(2,4);
    Reaction r = m.createReaction();
    ModifierSpeciesReference sr = m.createModifier();
    ListOf lo = r.getListOfModifiers();
    assertTrue( lo.equals(sr.getParentSBMLObject()) );
    assertTrue( lo.equals(r.getModifier(0).getParentSBMLObject()) );
    assertTrue( r.equals(lo.getParentSBMLObject()) );
  }

  public void test_SpeciesReference_Product_parent_add()
  {
    SpeciesReference sr = new SpeciesReference(2,4);
    Reaction r = new Reaction(2,4);
    sr.setSpecies("p");
    r.addProduct(sr);
    sr = null;
    ListOf lo = r.getListOfProducts();
    assertTrue( lo.equals(r.getProduct(0).getParentSBMLObject()) );
    assertTrue( r.equals(lo.getParentSBMLObject()) );
  }

  public void test_SpeciesReference_Product_parent_create()
  {
    Reaction r = new Reaction(2,4);
    SpeciesReference sr = r.createProduct();
    ListOf lo = r.getListOfProducts();
    assertTrue( lo.equals(r.getProduct(0).getParentSBMLObject()) );
    assertTrue( lo.equals(sr.getParentSBMLObject()) );
    assertTrue( r.equals(lo.getParentSBMLObject()) );
  }

  public void test_SpeciesReference_Product_parent_create_model()
  {
    Model m = new Model(2,4);
    Reaction r = m.createReaction();
    SpeciesReference sr = m.createProduct();
    ListOf lo = r.getListOfProducts();
    assertTrue( lo.equals(r.getProduct(0).getParentSBMLObject()) );
    assertTrue( lo.equals(sr.getParentSBMLObject()) );
    assertTrue( r.equals(lo.getParentSBMLObject()) );
  }

  public void test_SpeciesReference_Reactant_parent_add()
  {
    SpeciesReference sr = new SpeciesReference(2,4);
    Reaction r = new Reaction(2,4);
    sr.setSpecies("s");
    r.addReactant(sr);
    sr = null;
    ListOf lo = r.getListOfReactants();
    assertTrue( lo.equals(r.getReactant(0).getParentSBMLObject()) );
    assertTrue( r.equals(lo.getParentSBMLObject()) );
  }

  public void test_SpeciesReference_Reactant_parent_create()
  {
    Reaction r = new Reaction(2,4);
    SpeciesReference sr = r.createReactant();
    ListOf lo = r.getListOfReactants();
    assertTrue( lo.equals(r.getReactant(0).getParentSBMLObject()) );
    assertTrue( lo.equals(sr.getParentSBMLObject()) );
    assertTrue( r.equals(lo.getParentSBMLObject()) );
  }

  public void test_SpeciesReference_Reactant_parent_create_model()
  {
    Model m = new Model(2,4);
    Reaction r = m.createReaction();
    SpeciesReference sr = m.createReactant();
    ListOf lo = r.getListOfReactants();
    assertTrue( lo.equals(r.getReactant(0).getParentSBMLObject()) );
    assertTrue( lo.equals(sr.getParentSBMLObject()) );
    assertTrue( r.equals(lo.getParentSBMLObject()) );
  }

  public void test_SpeciesType_parent_NULL()
  {
    SBMLDocument d = new SBMLDocument(2,4);
    Model m = d.createModel();
    SpeciesType c = m.createSpeciesType();
    SpeciesType c1 = c.cloneObject();
    d = null;
    assertTrue( c1.getAncestorOfType(libsbml.SBML_MODEL) == null );
    assertTrue( c1.getParentSBMLObject() == null );
    assertEquals(c1.getSBMLDocument(),null);
    c1 = null;
  }

  public void test_SpeciesType_parent_add()
  {
    SpeciesType ia = new SpeciesType(2,4);
    ia.setId("s");
    Model m = new Model(2,4);
    m.addSpeciesType(ia);
    ia = null;
    ListOf lo = m.getListOfSpeciesTypes();
    assertTrue( lo.equals(m.getSpeciesType(0).getParentSBMLObject()) );
    assertTrue( m.equals(lo.getParentSBMLObject()) );
  }

  public void test_SpeciesType_parent_create()
  {
    Model m = new Model(2,4);
    SpeciesType st = m.createSpeciesType();
    ListOf lo = m.getListOfSpeciesTypes();
    assertTrue( lo.equals(m.getSpeciesType(0).getParentSBMLObject()) );
    assertTrue( lo.equals(st.getParentSBMLObject()) );
    assertTrue( m.equals(lo.getParentSBMLObject()) );
  }

  public void test_Species_parent_NULL()
  {
    SBMLDocument d = new SBMLDocument();
    Model m = d.createModel();
    Species c = m.createSpecies();
    Species c1 = c.cloneObject();
    d = null;
    assertTrue( c1.getAncestorOfType(libsbml.SBML_MODEL) == null );
    assertTrue( c1.getParentSBMLObject() == null );
    assertEquals(c1.getSBMLDocument(),null);
    c1 = null;
  }

  public void test_Species_parent_add()
  {
    Species ia = new Species(2,4);
    ia.setId("s");
    ia.setCompartment("c");
    Model m = new Model(2,4);
    m.addSpecies(ia);
    ia = null;
    ListOf lo = m.getListOfSpecies();
    assertTrue( lo.equals(m.getSpecies(0).getParentSBMLObject()) );
    assertTrue( m.equals(lo.getParentSBMLObject()) );
  }

  public void test_Species_parent_create()
  {
    Model m = new Model(2,4);
    Species s = m.createSpecies();
    ListOf lo = m.getListOfSpecies();
    assertTrue( lo.equals(s.getParentSBMLObject()) );
    assertTrue( lo.equals(m.getSpecies(0).getParentSBMLObject()) );
    assertTrue( m.equals(lo.getParentSBMLObject()) );
  }

  public void test_StoichiometryMath_parent_add()
  {
    StoichiometryMath m = new StoichiometryMath(2,4);
    SpeciesReference sr = new SpeciesReference(2,4);
    sr.setStoichiometryMath(m);
    m = null;
    assertTrue( sr.equals(sr.getStoichiometryMath().getParentSBMLObject()) );
    sr = null;
  }

  public void test_Trigger_parent_add()
  {
    Trigger d = new Trigger(2,4);
    Event e = new Event(2,4);
    e.setTrigger(d);
    d = null;
    assertTrue( e.equals(e.getTrigger().getParentSBMLObject()) );
    e = null;
  }

  public void test_UnitDefinition_parent_NULL()
  {
    SBMLDocument d = new SBMLDocument();
    Model m = d.createModel();
    UnitDefinition c = m.createUnitDefinition();
    Unit u = c.createUnit();
    assertTrue( u.getAncestorOfType(libsbml.SBML_UNIT_DEFINITION).equals(c) );
    UnitDefinition c1 = c.cloneObject();
    d = null;
    assertTrue( c1.getAncestorOfType(libsbml.SBML_MODEL) == null );
    assertTrue( c1.getParentSBMLObject() == null );
    assertEquals(c1.getSBMLDocument(),null);
    assertTrue( c1.getUnit(0).getAncestorOfType(libsbml.SBML_UNIT_DEFINITION).equals(c1) );
    assertTrue( c1.getUnit(0).getParentSBMLObject() != null );
    assertEquals(c1.getUnit(0).getSBMLDocument(),null);
    c1 = null;
  }

  public void test_UnitDefinition_parent_add()
  {
    UnitDefinition ia = new UnitDefinition(2,4);
    Model m = new Model(2,4);
    ia.setId("u");
    ia.createUnit();
    m.addUnitDefinition(ia);
    ia = null;
    ListOf lo = m.getListOfUnitDefinitions();
    assertTrue( lo.equals(m.getUnitDefinition(0).getParentSBMLObject()) );
    assertTrue( m.equals(lo.getParentSBMLObject()) );
  }

  public void test_UnitDefinition_parent_create()
  {
    Model m = new Model(2,4);
    UnitDefinition ud = m.createUnitDefinition();
    ListOf lo = m.getListOfUnitDefinitions();
    assertTrue( lo.equals(m.getUnitDefinition(0).getParentSBMLObject()) );
    assertTrue( lo.equals(ud.getParentSBMLObject()) );
    assertTrue( m.equals(lo.getParentSBMLObject()) );
  }

  public void test_Unit_parent_add()
  {
    UnitDefinition ud = new UnitDefinition(2,4);
    Unit u = new Unit(2,4);
    u.setKind(libsbml.UNIT_KIND_MOLE);
    ud.addUnit(u);
    u = null;
    assertTrue( ud.getNumUnits() == 1 );
    ListOf lo = ud.getListOfUnits();
    assertTrue( lo.equals(ud.getUnit(0).getParentSBMLObject()) );
    assertTrue( ud.equals(lo.getParentSBMLObject()) );
    ud = null;
  }

  public void test_Unit_parent_create()
  {
    UnitDefinition ud = new UnitDefinition(2,4);
    Unit u = ud.createUnit();
    assertTrue( ud.getNumUnits() == 1 );
    ListOf lo = ud.getListOfUnits();
    assertTrue( lo.equals(ud.getUnit(0).getParentSBMLObject()) );
    assertTrue( lo.equals(u.getParentSBMLObject()) );
    assertTrue( ud.equals(lo.getParentSBMLObject()) );
    ud = null;
  }

  public void test_Unit_parent_create_model()
  {
    Model m = new Model(2,4);
    UnitDefinition ud = m.createUnitDefinition();
    Unit u = m.createUnit();
    assertTrue( ud.getNumUnits() == 1 );
    ListOf lo = ud.getListOfUnits();
    assertTrue( lo.equals(ud.getUnit(0).getParentSBMLObject()) );
    assertTrue( lo.equals(u.getParentSBMLObject()) );
    assertTrue( ud.equals(lo.getParentSBMLObject()) );
    ud = null;
  }

  /**
   * Loads the SWIG-generated libSBML Java module when this class is
   * loaded, or reports a sensible diagnostic message about why it failed.
   */
  static
  {
    String varname;
    String shlibname;

    if (System.getProperty("mrj.version") != null)
    {
      varname = "DYLD_LIBRARY_PATH";    // We're on a Mac.
      shlibname = "libsbmlj.jnilib and/or libsbml.dylib";
    }
    else
    {
      varname = "LD_LIBRARY_PATH";      // We're not on a Mac.
      shlibname = "libsbmlj.so and/or libsbml.so";
    }

    try
    {
      System.loadLibrary("sbmlj");
      // For extra safety, check that the jar file is in the classpath.
      Class.forName("org.sbml.libsbml.libsbml");
    }
    catch (SecurityException e)
    {
      e.printStackTrace();
      System.err.println("Could not load the libSBML library files due to a"+
                         " security exception.\n");
      System.exit(1);
    }
    catch (UnsatisfiedLinkError e)
    {
      e.printStackTrace();
      System.err.println("Error: could not link with the libSBML library files."+
                         " It is likely\nyour " + varname +
                         " environment variable does not include the directories\n"+
                         "containing the " + shlibname + " library files.\n");
      System.exit(1);
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
      System.err.println("Error: unable to load the file libsbmlj.jar."+
                         " It is likely\nyour -classpath option and CLASSPATH" +
                         " environment variable\n"+
                         "do not include the path to libsbmlj.jar.\n");
      System.exit(1);
    }
  }
}
