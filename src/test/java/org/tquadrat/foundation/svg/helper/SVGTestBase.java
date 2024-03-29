/*
 * ============================================================================
 *  Copyright © 2002-2020 by Thomas Thrien.
 *  All Rights Reserved.
 * ============================================================================
 *  Licensed to the public under the agreements of the GNU Lesser General Public
 *  License, version 3.0 (the "License"). You may obtain a copy of the License at
 *
 *       http://www.gnu.org/licenses/lgpl.html
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations
 *  under the License.
 */

package org.tquadrat.foundation.svg.helper;

import static org.easymock.EasyMock.expect;
import static org.tquadrat.foundation.xml.builder.XMLBuilderUtils.Validator.VALIDATOR_AttributeName;
import static org.tquadrat.foundation.xml.builder.XMLBuilderUtils.Validator.VALIDATOR_ElementName;
import static org.tquadrat.foundation.xml.builder.XMLBuilderUtils.Validator.VALIDATOR_NMToken;
import static org.tquadrat.foundation.xml.builder.XMLBuilderUtils.Validator.VALIDATOR_Prefix;
import static org.tquadrat.foundation.xml.builder.XMLBuilderUtils.getAttributeNameValidator;
import static org.tquadrat.foundation.xml.builder.XMLBuilderUtils.getElementNameValidator;
import static org.tquadrat.foundation.xml.builder.XMLBuilderUtils.getNMTokenValidator;
import static org.tquadrat.foundation.xml.builder.XMLBuilderUtils.getPrefixValidator;
import static org.tquadrat.foundation.xml.builder.XMLBuilderUtils.setAttributeNameValidator;
import static org.tquadrat.foundation.xml.builder.XMLBuilderUtils.setElementNameValidator;
import static org.tquadrat.foundation.xml.builder.XMLBuilderUtils.setNMTokenValidator;
import static org.tquadrat.foundation.xml.builder.XMLBuilderUtils.setPrefixValidator;

import java.util.function.Predicate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.svg.SVGElementWithChildren;
import org.tquadrat.foundation.testutil.TestBaseClass;
import org.tquadrat.foundation.xml.builder.spi.Element;

/**
 *  The base class for all test classes in the SVG project.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: SVGTestBase.java 1076 2023-10-03 18:36:07Z tquadrat $
 *  @since 0.0.5
 *
 *  @UMLGraph.link
 */
@ClassVersion( sourceVersion = "$Id: SVGTestBase.java 1076 2023-10-03 18:36:07Z tquadrat $" )
public class SVGTestBase extends TestBaseClass
{
        /*------------*\
    ====** Attributes **=======================================================
        \*------------*/
    /**
     *  The current method that validates an XML attribute name.
     */
    private Predicate<CharSequence> m_AttributeNameValidator;

    /**
     *  The current method that validates an XML element name.
     */
    private Predicate<CharSequence> m_ElementNameValidator;

    /**
     *  The current method that validates an XML nmtoken.
     */
    private Predicate<CharSequence> m_NMTokenValidator;

    /**
     *  The current method that validates an XML namespace prefix.
     */
    private Predicate<CharSequence> m_PrefixValidator;

        /*--------------*\
    ====** Constructors **=====================================================
        \*--------------*/
    /**
     *  Creates a new {@code XMLTestBase} instance.
     */
    protected SVGTestBase()
    {
        super();
    }   //  XMLTestBase()

        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Creates a parent SVG element with the element name '{@code DUMMY}'.
     *
     *  @return The parent element.
     */
    protected final SVGElementWithChildren createParentElement() { return new SVGDummyContainer(); }

    /**
     *  Creates a parent SVG element.
     *
     *  @param  elementName The element name for the new element.
     *  @return The parent element.
     */
    protected final SVGElementWithChildren createParentElement( final String elementName ) { return new SVGDummyContainer( elementName ); }

    /**
     *  Creates a mocked instance of
     *  {@link Element}
     *  that will return {@code elementName} on each call to
     *  {@link Element#getElementName()}
     *  once
     *  {@link org.easymock.EasyMockSupport#replayAll()}
     *  was invoked.<br>
     *  <br>More expectations can be added to the mocked instance, but before
     *  it is used, a call to {@code replay()} or {@code replayAll()} is
     *  mandatory, in order to arm the mocked instance.
     *
     *  @param  elementName The name of the element.
     *  @return The mock for an {@code Element} instance.
     */
    protected final Element mockElement( final String elementName )
    {
        final Element retValue = mock( Element.class );

        expect( retValue.getElementName() )
            .andReturn( elementName )
            .anyTimes();
        expect( retValue.isBlock() )
            .andReturn( true )
            .anyTimes();

        //---* Done *----------------------------------------------------------
        return retValue;
    }   //  mockElement()

    /**
     *  Creates a mocked instance of
     *  {@link SVGElementWithChildren}
     *  that will return {@code elementName} on each call to
     *  {@link SVGElementWithChildren#getElementName()}
     *  once
     *  {@link org.easymock.EasyMockSupport#replayAll()}
     *  was invoked.<br>
     *  <br>More expectations can be added to the mocked instance, but before
     *  it is used, a call to {@code replay()} or {@code replayAll()} is
     *  mandatory, in order to arm the mocked instance.
     *
     *  @note Currently (as of December 2020) EasyMock is unable to mock sealed
     *      classes or interfaces. Therefore, this method cannot be used until
     *      this bug is fixed (or the feature is added, depending on your
     *      view). Meanwhile, the methods
     *      {@link #createParentElement()}
     *      and
     *      {@link #createParentElement(String)}
     *      should do the job.
     *
     *  @param  elementName The name of the element.
     *  @return The mock for an {@code SVGElementWithChildren} instance.
     */
    protected final SVGElementWithChildren mockSVGElementWithChildren( final String elementName )
    {
        final SVGElementWithChildren retValue = mock( SVGElementWithChildren.class );

        expect( retValue.getElementName() )
            .andReturn( elementName )
            .anyTimes();
        expect( retValue.isBlock() )
            .andReturn( true )
            .anyTimes();

        //---* Done *----------------------------------------------------------
        return retValue;
    }   //  mockSVGElementWithChildren()

    /**
     *  Ensures that the default validators are used. Tests may overwrite them
     *  for their own needs, but this will force that always the default is
     *  established at the beginning.
     */
    @BeforeEach
    final void ensureDefaultValidators()
    {
        m_AttributeNameValidator = getAttributeNameValidator();
        setAttributeNameValidator( VALIDATOR_AttributeName.getDefault() );

        m_ElementNameValidator = getElementNameValidator();
        setElementNameValidator( VALIDATOR_ElementName.getDefault() );

        m_NMTokenValidator = getNMTokenValidator();
        setNMTokenValidator( VALIDATOR_NMToken.getDefault() );

        m_PrefixValidator = getPrefixValidator();
        setPrefixValidator( VALIDATOR_Prefix.getDefault() );
    }   //  ensureDefaultValidators()

    /**
     *  Resets the validators to the values they had before the test.
     */
    @AfterEach
    final void resetValidators()
    {
        setAttributeNameValidator( m_AttributeNameValidator );
        setElementNameValidator( m_ElementNameValidator );
        setNMTokenValidator( m_NMTokenValidator );
        setPrefixValidator( m_PrefixValidator );
    }   //  resetValidators()
}
//  class SVGTestBase

/*
 *  End of File
 */