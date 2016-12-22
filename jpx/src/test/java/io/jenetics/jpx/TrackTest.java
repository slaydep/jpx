/*
 * Java GPX Library (@__identifier__@).
 * Copyright (c) @__year__@ Franz Wilhelmstötter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:
 *    Franz Wilhelmstötter (franz.wilhelmstoetter@gmail.com)
 */
package io.jenetics.jpx;

import static java.lang.String.format;

import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

/**
 * @author <a href="mailto:franz.wilhelmstoetter@gmx.at">Franz Wilhelmstötter</a>
 */
@Test
public class TrackTest extends XMLStreamTestBase<Track> {

	@Override
	protected Params<Track> params(final Random random) {
		return new Params<>(
			() -> nextTrack(random),
			Track.reader(),
			Track::write
		);
	}

	public static Track nextTrack(final Random random) {
		return Track.of(
			random.nextBoolean()
				? format("name_%s", random.nextInt(100))
				: null,
			random.nextBoolean()
				? format("comment_%s", random.nextInt(100))
				: null,
			random.nextBoolean()
				? format("description_%s", random.nextInt(100))
				: null,
			random.nextBoolean()
				? format("source_%s", random.nextInt(100))
				: null,
			LinkTest.nextLinks(random),
			random.nextBoolean()
				? UInt.of(random.nextInt(100))
				: null,
			random.nextBoolean()
				? format("type_%s", random.nextInt(100))
				: null,
			TrackSegmentTest.nextTrackSegments(random)
		);
	}

	public static List<Track> nextTracks(final Random random) {
		return nextObjects(() -> nextTrack(random), random);
	}

}