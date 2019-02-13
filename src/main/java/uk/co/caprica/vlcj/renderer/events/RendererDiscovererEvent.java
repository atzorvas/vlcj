/*
 * This file is part of VLCJ.
 *
 * VLCJ is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * VLCJ is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with VLCJ.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright 2009-2019 Caprica Software Limited.
 */

package uk.co.caprica.vlcj.renderer.events;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.eventmanager.EventNotification;
import uk.co.caprica.vlcj.renderer.RendererDiscoverer;
import uk.co.caprica.vlcj.renderer.RendererDiscovererEventListener;

/**
 * Specification for a renderer discoverer event.
 */
abstract class RendererDiscovererEvent implements EventNotification<RendererDiscovererEventListener> {

    protected final LibVlc libvlc;

    /**
     * The renderer discoverer the event relates to.
     */
    protected final RendererDiscoverer rendererDiscoverer;

    /**
     * Create a media player event.
     *
     * @param libvlc
     * @param rendererDiscoverer renderer discoverer that the event relates to
     */
    protected RendererDiscovererEvent(LibVlc libvlc, RendererDiscoverer rendererDiscoverer) {
        this.libvlc = libvlc;
        this.rendererDiscoverer = rendererDiscoverer;
    }

}
