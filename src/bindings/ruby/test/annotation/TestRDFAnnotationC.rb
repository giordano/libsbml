#
# @file    TestRDFAnnotationC.rb
# @brief   RDFAnnotation parser unit tests
#
# @author  Akiya Jouraku (Ruby conversion)
# @author  Sarah Keating 
#
# $Id$
# $HeadURL$
#
# This test file was converted from src/sbml/test/TestRDFAnnotationC.c
# with the help of conversion sciprt (ctest_converter.pl).
#
#<!---------------------------------------------------------------------------
# This file is part of libSBML.  Please visit http://sbml.org for more
# information about SBML, and the latest version of libSBML.
#
# Copyright 2005-2009 California Institute of Technology.
# Copyright 2002-2005 California Institute of Technology and
#                     Japan Science and Technology Corporation.
# 
# This library is free software; you can redistribute it and/or modify it
# under the terms of the GNU Lesser General Public License as published by
# the Free Software Foundation.  A copy of the license agreement is provided
# in the file named "LICENSE.txt" included with this software distribution
# and also available online as http://sbml.org/software/libsbml/license.html
#--------------------------------------------------------------------------->*/
require 'test/unit'
require 'libSBML'

class TestRDFAnnotationC < Test::Unit::TestCase

  def setup
    filename = "../../annotation/test/test-data/annotation.xml"
    @@d = LibSBML::readSBML(filename)
    @@m = @@d.getModel()
  end

  def teardown
    @@d = nil
  end

  def test_RDFAnnotation_C_delete
    obj = @@m.getCompartment(0)
    node = LibSBML::RDFAnnotationParser.parseCVTerms(obj)
    n1 = LibSBML::RDFAnnotationParser.deleteRDFAnnotation(node)
    assert( n1.getNumChildren() == 0 )
    assert ((  "annotation" == n1.getName() ))
    node = nil
  end

  def test_RDFAnnotation_C_getModelHistory
    assert( !( @@m == nil) )
    history = @@m.getModelHistory()
    assert( history != nil )
    mc = history.getCreator(0)
    assert ((  "Le Novere" == mc.getFamilyName() ))
    assert ((  "Nicolas" == mc.getGivenName() ))
    assert ((  "lenov@ebi.ac.uk" == mc.getEmail() ))
    assert ((  "EMBL-EBI" == mc.getOrganisation() ))
    date = history.getCreatedDate()
    assert( date.getYear() == 2005 )
    assert( date.getMonth() == 2 )
    assert( date.getDay() == 2 )
    assert( date.getHour() == 14 )
    assert( date.getMinute() == 56 )
    assert( date.getSecond() == 11 )
    assert( date.getSignOffset() == 0 )
    assert( date.getHoursOffset() == 0 )
    assert( date.getMinutesOffset() == 0 )
    assert ((  "2005-02-02T14:56:11Z" == date.getDateAsString() ))
    date = history.getModifiedDate()
    assert( date.getYear() == 2006 )
    assert( date.getMonth() == 5 )
    assert( date.getDay() == 30 )
    assert( date.getHour() == 10 )
    assert( date.getMinute() == 46 )
    assert( date.getSecond() == 2 )
    assert( date.getSignOffset() == 0 )
    assert( date.getHoursOffset() == 0 )
    assert( date.getMinutesOffset() == 0 )
    assert ((  "2006-05-30T10:46:02Z" == date.getDateAsString() ))
  end

  def test_RDFAnnotation_C_parseCVTerms
    obj = @@m.getCompartment(0)
    node = LibSBML::RDFAnnotationParser.parseCVTerms(obj)
    assert( node.getNumChildren() == 1 )
    rdf = node.getChild(0)
    assert ((  "RDF" == rdf.getName() ))
    assert ((  "rdf" == rdf.getPrefix() ))
    assert ((  "http://www.w3.org/1999/02/22-rdf-syntax-ns#" == rdf.getURI() ))
    assert( rdf.getNumChildren() == 1 )
    desc = rdf.getChild(0)
    assert ((  "Description" == desc.getName() ))
    assert ((  "rdf" == desc.getPrefix() ))
    assert ((  "http://www.w3.org/1999/02/22-rdf-syntax-ns#" == desc.getURI() ))
    assert( desc.getNumChildren() == 1 )
    is1 = desc.getChild(0)
    assert ((  "is" == is1.getName() ))
    assert ((  "bqbiol" == is1.getPrefix() ))
    assert( is1.getNumChildren() == 1 )
    bag = is1.getChild(0)
    assert ((  "Bag" == bag.getName() ))
    assert ((  "rdf" == bag.getPrefix() ))
    assert ((  "http://www.w3.org/1999/02/22-rdf-syntax-ns#" == bag.getURI() ))
    assert( bag.getNumChildren() == 4 )
    li = bag.getChild(0)
    assert ((  "li" == li.getName() ))
    assert ((  "rdf" == li.getPrefix() ))
    assert ((  "http://www.w3.org/1999/02/22-rdf-syntax-ns#" == li.getURI() ))
    assert( li.getNumChildren() == 0 )
    li1 = bag.getChild(1)
    assert ((  "li" == li1.getName() ))
    assert ((  "rdf" == li1.getPrefix() ))
    assert ((  "http://www.w3.org/1999/02/22-rdf-syntax-ns#" == li1.getURI() ))
    assert( li1.getNumChildren() == 0 )
    li2 = bag.getChild(2)
    assert ((  "li" == li2.getName() ))
    assert ((  "rdf" == li2.getPrefix() ))
    assert ((  "http://www.w3.org/1999/02/22-rdf-syntax-ns#" == li2.getURI() ))
    assert( li2.getNumChildren() == 0 )
    li3 = bag.getChild(3)
    assert ((  "li" == li3.getName() ))
    assert ((  "rdf" == li3.getPrefix() ))
    assert ((  "http://www.w3.org/1999/02/22-rdf-syntax-ns#" == li3.getURI() ))
    assert( li3.getNumChildren() == 0 )
    node = nil
  end

  def test_RDFAnnotation_C_parseModelHistory
    node = LibSBML::RDFAnnotationParser.parseModelHistory(@@m)
    assert( node.getNumChildren() == 1 )
    rdf = node.getChild(0)
    assert ((  "RDF" == rdf.getName() ))
    assert ((  "rdf" == rdf.getPrefix() ))
    assert ((  "http://www.w3.org/1999/02/22-rdf-syntax-ns#" == rdf.getURI() ))
    assert( rdf.getNumChildren() == 1 )
    desc = rdf.getChild(0)
    assert ((  "Description" == desc.getName() ))
    assert ((  "rdf" == desc.getPrefix() ))
    assert ((  "http://www.w3.org/1999/02/22-rdf-syntax-ns#" == desc.getURI() ))
    assert( desc.getNumChildren() == 3 )
    creator = desc.getChild(0)
    assert ((  "creator" == creator.getName() ))
    assert ((  "dc" == creator.getPrefix() ))
    assert ((  "http://purl.org/dc/elements/1.1/" == creator.getURI() ))
    assert( creator.getNumChildren() == 1 )
    bag = creator.getChild(0)
    assert ((  "Bag" == bag.getName() ))
    assert ((  "rdf" == bag.getPrefix() ))
    assert ((  "http://www.w3.org/1999/02/22-rdf-syntax-ns#" == bag.getURI() ))
    assert( bag.getNumChildren() == 1 )
    li = bag.getChild(0)
    assert ((  "li" == li.getName() ))
    assert ((  "rdf" == li.getPrefix() ))
    assert ((  "http://www.w3.org/1999/02/22-rdf-syntax-ns#" == li.getURI() ))
    assert( li.getNumChildren() == 3 )
    n = li.getChild(0)
    assert ((  "N" == n.getName() ))
    assert ((  "vCard" == n.getPrefix() ))
    assert ((  "http://www.w3.org/2001/vcard-rdf/3.0#" == n.getURI() ))
    assert( n.getNumChildren() == 2 )
    family = n.getChild(0)
    assert ((  "Family" == family.getName() ))
    assert ((  "vCard" == family.getPrefix() ))
    assert ((  "http://www.w3.org/2001/vcard-rdf/3.0#" == family.getURI() ))
    assert( family.getNumChildren() == 1 )
    given = n.getChild(1)
    assert ((  "Given" == given.getName() ))
    assert ((  "vCard" == given.getPrefix() ))
    assert ((  "http://www.w3.org/2001/vcard-rdf/3.0#" == given.getURI() ))
    assert( given.getNumChildren() == 1 )
    email = li.getChild(1)
    assert ((  "EMAIL" == email.getName() ))
    assert ((  "vCard" == email.getPrefix() ))
    assert ((  "http://www.w3.org/2001/vcard-rdf/3.0#" == email.getURI() ))
    assert( email.getNumChildren() == 1 )
    org = li.getChild(2)
    assert ((  "ORG" == org.getName() ))
    assert ((  "vCard" == org.getPrefix() ))
    assert ((  "http://www.w3.org/2001/vcard-rdf/3.0#" == org.getURI() ))
    assert( org.getNumChildren() == 1 )
    orgname = org.getChild(0)
    assert ((  "Orgname" == orgname.getName() ))
    assert ((  "vCard" == orgname.getPrefix() ))
    assert ((  "http://www.w3.org/2001/vcard-rdf/3.0#" == orgname.getURI() ))
    assert( orgname.getNumChildren() == 1 )
    created = desc.getChild(1)
    assert ((  "created" == created.getName() ))
    assert ((  "dcterms" == created.getPrefix() ))
    assert ((  "http://purl.org/dc/terms/" == created.getURI() ))
    assert( created.getNumChildren() == 1 )
    cr_date = created.getChild(0)
    assert ((  "W3CDTF" == cr_date.getName() ))
    assert ((  "dcterms" == cr_date.getPrefix() ))
    assert ((  "http://purl.org/dc/terms/" == cr_date.getURI() ))
    assert( cr_date.getNumChildren() == 1 )
    modified = desc.getChild(2)
    assert ((  "modified" == modified.getName() ))
    assert ((  "dcterms" == modified.getPrefix() ))
    assert ((  "http://purl.org/dc/terms/" == modified.getURI() ))
    assert( modified.getNumChildren() == 1 )
    mo_date = created.getChild(0)
    assert ((  "W3CDTF" == mo_date.getName() ))
    assert ((  "dcterms" == mo_date.getPrefix() ))
    assert ((  "http://purl.org/dc/terms/" == mo_date.getURI() ))
    assert( mo_date.getNumChildren() == 1 )
    node = nil
  end

end
