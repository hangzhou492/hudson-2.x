/**
 * The MIT License
 *
 * Copyright (c) 2010-2011 Sonatype, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.eclipse.hudson.maven.plugin.ui.gwt.buildinfo.event;

import org.eclipse.hudson.gwt.common.EventSupport;
import org.eclipse.hudson.maven.plugin.ui.gwt.buildinfo.event.BuildStateSelectedEvent.Handler;

import com.google.gwt.event.shared.EventHandler;
import org.hudsonci.maven.model.state.BuildStateDTO;

/**
 * Indicates that a {@link BuildStateDTO} has been selected.
 * 
 * @author Jamie Whitehouse
 * @since 2.1.0
 */
public class BuildStateSelectedEvent
    extends EventSupport<Handler>
{
    /**
     * Handler interface for {@link BuildStateSelectedEvent} events.
     */
    public static interface Handler
        extends EventHandler
    {
        void onSelected( BuildStateSelectedEvent event );
    }

    public static Type<Handler> TYPE = new Type<Handler>();

    private final BuildStateDTO state;

    public BuildStateSelectedEvent( final BuildStateDTO selectedState )
    {
        super(TYPE);
        this.state = selectedState;
    }

    public BuildStateDTO getBuildState()
    {
        return state;
    }

    @Override
    public Type<Handler> getAssociatedType()
    {
        return TYPE;
    }

    @Override
    protected void dispatch( Handler handler )
    {
        handler.onSelected( this );
    }
}