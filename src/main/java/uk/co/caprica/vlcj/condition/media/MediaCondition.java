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

package uk.co.caprica.vlcj.condition.media;

import uk.co.caprica.vlcj.enums.MediaParsedStatus;
import uk.co.caprica.vlcj.enums.Meta;
import uk.co.caprica.vlcj.enums.State;
import uk.co.caprica.vlcj.media.Media;
import uk.co.caprica.vlcj.media.MediaRef;
import uk.co.caprica.vlcj.media.MediaEventAdapter;
import uk.co.caprica.vlcj.media.MediaEventListener;
import uk.co.caprica.vlcj.model.Picture;
import uk.co.caprica.vlcj.condition.Condition;

abstract public class MediaCondition<R> extends Condition<Media, R> implements MediaEventListener {

    private final MediaEventListener internalListener = new InternalListener();

    protected MediaCondition(Media component) {
        super(component);
    }

    @Override
    protected final void startListening(Media component) {
        component.events().addMediaEventListener(internalListener);
        component.events().addMediaEventListener(this);
    }

    @Override
    protected final void stopListening(Media component) {
        component.events().removeMediaEventListener(internalListener);
        component.events().removeMediaEventListener(this);
    }

    private class InternalListener extends MediaEventAdapter {
        @Override
        public void mediaStateChanged(Media media, State newState) {
            switch (newState) {
                case ENDED:
                    MediaCondition.super.finished();
                    break;
                case ERROR:
                    MediaCondition.super.error();
                    break;
            }
        }
    }

    // === MediaEventListener ==================================================

    @Override
    public void mediaMetaChanged(Media media, Meta metaType) {
    }

    @Override
    public void mediaSubItemAdded(Media media, MediaRef newChild) {
    }

    @Override
    public void mediaDurationChanged(Media media, long newDuration) {
    }

    @Override
    public void mediaParsedChanged(Media media, MediaParsedStatus newStatus) {
    }

    @Override
    public void mediaFreed(Media media, MediaRef mediaFreed) {
    }

    @Override
    public void mediaStateChanged(Media media, State newState) {
    }

    @Override
    public void mediaSubItemTreeAdded(Media media, MediaRef item) {
    }

    @Override
    public void mediaThumbnailGenerated(Media media, Picture picture) {
    }

}
