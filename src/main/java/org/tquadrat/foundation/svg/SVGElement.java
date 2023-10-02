/*
 * ============================================================================
 * Copyright © 2002-2023 by Thomas Thrien.
 * All Rights Reserved.
 * ============================================================================
 * Licensed to the public under the agreements of the GNU Lesser General Public
 * License, version 3.0 (the "License"). You may obtain a copy of the License at
 *
 *      http://www.gnu.org/licenses/lgpl.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.tquadrat.foundation.svg;

import static java.util.Arrays.asList;
import static org.apiguardian.api.API.Status.STABLE;
import static org.tquadrat.foundation.lang.CommonConstants.XMLATTRIBUTE_Language;
import static org.tquadrat.foundation.lang.CommonConstants.XMLATTRIBUTE_Whitespace;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_Id;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_Lang;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_TabIndex;
import static org.tquadrat.foundation.svg.SVGUtils.XMLATTRIBUTE_Base;
import static org.tquadrat.foundation.svg.type.SVGElementCategory.retrieveElementCategory;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import org.apiguardian.api.API;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.svg.internal.SVGElementImpl;
import org.tquadrat.foundation.svg.type.SVGElementCategory;
import org.tquadrat.foundation.xml.builder.XMLElement;
import org.tquadrat.foundation.xml.builder.spi.Element;

/**
 *  The definition of an SVG element.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: SVGElement.java 1074 2023-10-02 12:05:06Z tquadrat $
 *  @since 0.0.5
 *
 *  @UMLGraph.link
 */
@ClassVersion( sourceVersion = "$Id: SVGElement.java 1074 2023-10-02 12:05:06Z tquadrat $" )
@API( status = STABLE, since = "0.0.5" )
public sealed interface SVGElement extends Element
    permits SVGElementWithChildren, SVGStyle, SVGUse, SVGElementImpl
{
        /*------------------------*\
    ====** Static Initialisations **===========================================
        \*------------------------*/
    /**
     *  The core attributes.
     */
    @SuppressWarnings( "StaticCollection" )
    public static final List<String> CORE_ATTRIBUTES = List.copyOf( asList(
        SVGATTRIBUTE_Id,
        SVGATTRIBUTE_Lang,
        SVGATTRIBUTE_TabIndex,
        XMLATTRIBUTE_Base,
        XMLATTRIBUTE_Language,
        XMLATTRIBUTE_Whitespace
    ) );

        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Adds a comment.
     *
     *  @param  comment The comment text.
     *  @return This instance.
     *  @throws IllegalArgumentException    No comment allowed for this element.
     */
    public XMLElement addComment( final CharSequence comment ) throws IllegalArgumentException;

    /**
     *  Returns the element category.
     *
     *  @return The element categories; will never be {@code null}.
     */
    public default Collection<SVGElementCategory> getSVGElementCategory()
    {
        return retrieveElementCategory( getElementName() );
    }   //  getSVGElementCategory()

    /**
     *  Sets the SVG id for the element.<br>
     *  <br>The type will be validated using the method that is provided by a
     *  call to
     *  {@link org.tquadrat.foundation.xml.builder.XMLBuilderUtils#getNMTokenValidator()}.
     *
     *  @param  id  The id.
     *  @return This instance.
     *  @throws IllegalArgumentException    An attribute with the given name is
     *      not valid for the element, or no attributes are allowed at all, or
     *      the type is not a valid NMToken.
     *
     *  @see org.tquadrat.foundation.svg.SVGUtils#SVGATTRIBUTE_Id
     */
    public XMLElement setId( final String id ) throws IllegalArgumentException;

    /**
     *  Sets the human language attribute for this SVG element.
     *
     *  @param  value   The language code.
     */
    public void setLang( final Locale value );

    /**
     *  Sets attribute that defines how space is handled by this SVG element.
     *
     *  @param  flag    {@code true} to preserve space in the source,
     *      {@code false} for the XML default behaviour (ignoring excessive
     *      whitespace).
     */
    public void setPreserveSpace( final boolean flag );

    /**
     *  Sets the tabulator index for the SVG element.
     *
     *  @param  value   The tabindex type.
     */
    public void setTabIndex( final int value );

    /**
     *  Sets the title for the SVG element.<br>
     *  <br>This is not an attribute, instead a
     *  <code>&lt;{@value org.tquadrat.foundation.svg.SVGUtils#SVGELEMENT_Title}&gt;</code>
     *  element will be added as a child.
     *
     *  @param  title   The title; nothing happens if {@code null}, empty, or
     *      blank.
     *  @throws IllegalStateException   The given title is not {@code null},
     *      empty, or blank, and a title was applied already earlier.
     */
    public void setTitle( final CharSequence title );

    /**
     *  Sets XML attribute for the base URI that is used to reference external
     *  resources.
     *
     *  @param  value   The base URI.
     */
    public void setXMLBase( final URI value );

    /**
     *  Sets the id for the element.<br>
     *  <br>The type will be validated using the method that is provided by a
     *  call to
     *  {@link org.tquadrat.foundation.xml.builder.XMLBuilderUtils#getNMTokenValidator()}.
     *
     *  @param  id  The id.
     *  @throws IllegalArgumentException    An attribute with the given name is
     *      not valid for the element, or no attributes are allowed at all, or
     *      the type is not a valid NMToken.
     *
     *  @see org.tquadrat.foundation.lang.CommonConstants#XMLATTRIBUTE_Id
     */
    public void setXMLId( final String id ) throws IllegalArgumentException;

    /**
     *  Sets XML attribute for the human language for this SVG element.
     *
     *  @param  value   The language code.
     */
    public void setXMLLang( final Locale value );
}
//  interface SVGElement

/*
 *  End of File
 */