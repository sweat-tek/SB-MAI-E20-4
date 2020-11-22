/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.io.commands;

import java.awt.geom.Point2D;
import java.io.IOException;
import org.jhotdraw.geom.BezierPath;
import org.jhotdraw.io.StreamPosTokenizer;

/**
 *
 * @author Peder
 */
public class ToPath {
    public static char relativeMoveto(StreamPosTokenizer streamTokenizer, String str, Point2D.Double p, BezierPath path) throws IOException {
        char nextCommand;
        toPathCommandHasParameter(streamTokenizer,"dx coordinate", "m", str);
        p.x += streamTokenizer.nval;
        toPathCommandHasParameter(streamTokenizer,"dy coordinate", "m", str);
        p.y += streamTokenizer.nval;
        path.moveTo(p.x, p.y);
        nextCommand = 'l';
        return nextCommand;
    }

    public static char absoluteMoveto(StreamPosTokenizer streamTokenizer, String str, Point2D.Double p, BezierPath path) throws IOException {
        char nextCommand;
        toPathCommandHasParameter(streamTokenizer,"x coordinate", "M", str);
        p.x = streamTokenizer.nval;
        toPathCommandHasParameter(streamTokenizer,"y coordinate", "M", str);
        p.y = streamTokenizer.nval;
        path.moveTo(p.x, p.y);
        nextCommand = 'L';
        return nextCommand;
    }

    public static void closePath(Point2D.Double p, BezierPath path) {
        // close path
        p.x = path.get(0).x[0];
        p.y = path.get(0).y[0];
        
        // If the last point and the first point are the same, we
        // can merge them
        if (path.size() > 1) {
            BezierPath.Node first = path.get(0);
            BezierPath.Node last = path.get(path.size() - 1);
            if (first.x[0] == last.x[0] &&
                    first.y[0] == last.y[0]) {
                if ((last.mask & BezierPath.C1_MASK) != 0) {
                    first.mask |= BezierPath.C1_MASK;
                    first.x[1] = last.x[1];
                    first.y[1] = last.y[1];
                }
                path.remove(path.size() - 1);
            }
        }
        path.setClosed(true);
    }

    public static char absoluteLineto(StreamPosTokenizer streamTokenizer, String str, Point2D.Double p, BezierPath path) throws IOException {
        char nextCommand;
        // absolute-lineto x y
        toPathCommandHasParameter(streamTokenizer,"x coordinate", "L", str);
        p.x = streamTokenizer.nval;
        toPathCommandHasParameter(streamTokenizer,"y coordinate", "L", str);
        p.y = streamTokenizer.nval;
        path.lineTo(p.x, p.y);
        nextCommand = 'L';
        return nextCommand;
    }

    public static char relativeLineto(StreamPosTokenizer streamTokenizer, String str, Point2D.Double p, BezierPath path) throws IOException {
        char nextCommand;
        // relative-lineto dx dy
        toPathCommandHasParameter(streamTokenizer,"dx coordinate", "l", str);
        p.x += streamTokenizer.nval;
        toPathCommandHasParameter(streamTokenizer,"dy coordinate", "l", str);
        p.y += streamTokenizer.nval;
        path.lineTo(p.x, p.y);
        nextCommand = 'l';
        return nextCommand;
    }

    public static char absoluteHorizontalLineto(StreamPosTokenizer streamTokenizer, String str, Point2D.Double p, BezierPath path) throws IOException {
        char nextCommand;
        // absolute-horizontal-lineto x
        toPathCommandHasParameter(streamTokenizer,"x coordinate", "H", str);
        p.x = streamTokenizer.nval;
        path.lineTo(p.x, p.y);
        nextCommand = 'H';
        return nextCommand;
    }

    public static char relativeHorizontalLineto(StreamPosTokenizer streamTokenizer, String str, Point2D.Double p, BezierPath path) throws IOException {
        char nextCommand;
        // relative-horizontal-lineto dx
        toPathCommandHasParameter(streamTokenizer,"dx coordinate", "h", str);
        p.x += streamTokenizer.nval;
        path.lineTo(p.x, p.y);
        nextCommand = 'h';
        return nextCommand;
    }

    public static char absoluteVerticalLineto(StreamPosTokenizer streamTokenizer, String str, Point2D.Double p, BezierPath path) throws IOException {
        char nextCommand;
        // absolute-vertical-lineto y
        toPathCommandHasParameter(streamTokenizer,"y coordinate", "V", str);
        p.y = streamTokenizer.nval;
        path.lineTo(p.x, p.y);
        nextCommand = 'V';
        return nextCommand;
    }

    public static char relativeVerticalLineto(StreamPosTokenizer streamTokenizer, String str, Point2D.Double p, BezierPath path) throws IOException {
        char nextCommand;
        // relative-vertical-lineto dy
        toPathCommandHasParameter(streamTokenizer,"dy coordinate", "v", str);
        p.y += streamTokenizer.nval;
        path.lineTo(p.x, p.y);
        nextCommand = 'v';
        return nextCommand;
    }

    public static char relativeEllipticalArc(StreamPosTokenizer streamTokenizer, String str, Point2D.Double p, BezierPath path) throws IOException {
        char nextCommand;
        // relative-elliptical-arc rx ry x-axis-rotation large-arc-flag sweep-flag x y
        toPathCommandHasParameter(streamTokenizer,"rx coordinate", "a", str);
        // If rX or rY have negative signs, these are dropped;
        // the absolute value is used instead.
        double rx = streamTokenizer.nval;
        toPathCommandHasParameter(streamTokenizer,"ry coordinate", "a", str);
        double ry = streamTokenizer.nval;
        toPathCommandHasParameter(streamTokenizer,"x-axis-rotation", "a", str);
        double xAxisRotation = streamTokenizer.nval;
        toPathCommandHasParameter(streamTokenizer,"large-arc-flag", "a", str);
        boolean largeArcFlag = streamTokenizer.nval != 0;
        toPathCommandHasParameter(streamTokenizer,"sweep-flag", "a", str);
        boolean sweepFlag = streamTokenizer.nval != 0;
        toPathCommandHasParameter(streamTokenizer,"x coordinate", "a", str);
        p.x += streamTokenizer.nval;
        toPathCommandHasParameter(streamTokenizer,"y coordinate", "a", str);
        p.y += streamTokenizer.nval;
        path.arcTo(rx, ry, xAxisRotation, largeArcFlag, sweepFlag, p.x, p.y);
        nextCommand = 'a';
        return nextCommand;
    }

    public static char absoluteEllipticalArc(StreamPosTokenizer streamTokenizer, String str, Point2D.Double p, BezierPath path) throws IOException {
        char nextCommand;
        // absolute-elliptical-arc rx ry x-axis-rotation large-arc-flag sweep-flag x y
        toPathCommandHasParameter(streamTokenizer,"rx coordinate", "A", str);
        // If rX or rY have negative signs, these are dropped;
        // the absolute value is used instead.
        double rx = streamTokenizer.nval;
        toPathCommandHasParameter(streamTokenizer,"ry coordinate", "A", str);
        double ry = streamTokenizer.nval;
        toPathCommandHasParameter(streamTokenizer,"x-axis-rotation", "A", str);
        double xAxisRotation = streamTokenizer.nval;
        toPathCommandHasParameter(streamTokenizer,"large-arc-flag", "A", str);
        boolean largeArcFlag = streamTokenizer.nval != 0;
        toPathCommandHasParameter(streamTokenizer,"sweep-flag", "A", str);
        boolean sweepFlag = streamTokenizer.nval != 0;
        toPathCommandHasParameter(streamTokenizer,"x coordinate", "A", str);
        p.x = streamTokenizer.nval;
        toPathCommandHasParameter(streamTokenizer,"y coordinate", "A", str);
        p.y = streamTokenizer.nval;
        path.arcTo(rx, ry, xAxisRotation, largeArcFlag, sweepFlag, p.x, p.y);
        nextCommand = 'A';
        return nextCommand;
    }

    public static char relativeShorthandQuadto(BezierPath path, Point2D.Double c1, StreamPosTokenizer streamTokenizer, String str, Point2D.Double p) throws IOException {
        BezierPath.Node node;
        char nextCommand;
        // relative-shorthand-quadto dx dy
        node = path.get(path.size() - 1);
        c1.x = node.x[0] * 2d - node.x[1];
        c1.y = node.y[0] * 2d - node.y[1];
        toPathCommandHasParameter(streamTokenizer,"dx coordinate", "t", str);
        p.x += streamTokenizer.nval;
        toPathCommandHasParameter(streamTokenizer,"dy coordinate", "t", str);
        p.y += streamTokenizer.nval;
        path.quadTo(c1.x, c1.y, p.x, p.y);
        nextCommand = 's';
        return nextCommand;
    }

    public static char absoluteShorthandQuadto(BezierPath path, Point2D.Double c1, StreamPosTokenizer streamTokenizer, String str, Point2D.Double p) throws IOException {
        BezierPath.Node node;
        char nextCommand;
        // absolute-shorthand-quadto x y
        node = path.get(path.size() - 1);
        c1.x = node.x[0] * 2d - node.x[1];
        c1.y = node.y[0] * 2d - node.y[1];
        toPathCommandHasParameter(streamTokenizer,"x coordinate", "T", str);
        p.x = streamTokenizer.nval;
        toPathCommandHasParameter(streamTokenizer,"y coordinate", "T", str);
        p.y = streamTokenizer.nval;
        path.quadTo(c1.x, c1.y, p.x, p.y);
        nextCommand = 'T';
        return nextCommand;
    }

    public static char relativeQuadto(StreamPosTokenizer streamTokenizer, String str, Point2D.Double c1, Point2D.Double p, BezierPath path) throws IOException {
        char nextCommand;
        // relative-quadto dx1 dy1 dx dy
        toPathCommandHasParameter(streamTokenizer,"dx1 coordinate", "q", str);
        c1.x = p.x + streamTokenizer.nval;
        toPathCommandHasParameter(streamTokenizer,"dy1 coordinate", "q", str);
        c1.y = p.y + streamTokenizer.nval;
        toPathCommandHasParameter(streamTokenizer,"dx coordinate", "q", str);
        p.x += streamTokenizer.nval;
        toPathCommandHasParameter(streamTokenizer,"dy coordinate", "q", str);
        p.y += streamTokenizer.nval;
        path.quadTo(c1.x, c1.y, p.x, p.y);
        nextCommand = 'q';
        return nextCommand;
    }

    public static char absoluteQuadto(StreamPosTokenizer streamTokenizer, String str, Point2D.Double c1, Point2D.Double p, BezierPath path) throws IOException {
        char nextCommand;
        // absolute-quadto x1 y1 x y
        toPathCommandHasParameter(streamTokenizer,"x1 coordinate", "Q", str);
        c1.x = streamTokenizer.nval;
        toPathCommandHasParameter(streamTokenizer,"y1 coordinate", "Q", str);
        c1.y = streamTokenizer.nval;
        toPathCommandHasParameter(streamTokenizer,"x coordinate", "Q", str);
        p.x = streamTokenizer.nval;
        toPathCommandHasParameter(streamTokenizer,"y coordinate", "Q", str);
        p.y = streamTokenizer.nval;
        path.quadTo(c1.x, c1.y, p.x, p.y);
        nextCommand = 'Q';
        return nextCommand;
    }

    public static char relativeShorthandCurveto(BezierPath path, Point2D.Double c1, StreamPosTokenizer streamTokenizer, String str, Point2D.Double c2, Point2D.Double p) throws IOException {
        BezierPath.Node node;
        char nextCommand;
        // relative-shorthand-curveto dx2 dy2 dx dy
        node = path.get(path.size() - 1);
        c1.x = node.x[0] * 2d - node.x[1];
        c1.y = node.y[0] * 2d - node.y[1];
        toPathCommandHasParameter(streamTokenizer,"dx2 coordinate", "s", str);
        c2.x = p.x + streamTokenizer.nval;
        toPathCommandHasParameter(streamTokenizer,"dy2 coordinate", "s", str);
        c2.y = p.y + streamTokenizer.nval;
        toPathCommandHasParameter(streamTokenizer,"dx coordinate", "s", str);
        p.x += streamTokenizer.nval;
        toPathCommandHasParameter(streamTokenizer,"dy coordinate", "s", str);
        p.y += streamTokenizer.nval;
        path.curveTo(c1.x, c1.y, c2.x, c2.y, p.x, p.y);
        nextCommand = 's';
        return nextCommand;
    }

    public static char absoluteShorthandCurveto(BezierPath path, Point2D.Double c1, StreamPosTokenizer streamTokenizer, String str, Point2D.Double c2, Point2D.Double p) throws IOException {
        BezierPath.Node node;
        char nextCommand;
        // absolute-shorthand-curveto x2 y2 x y
        node = path.get(path.size() - 1);
        c1.x = node.x[0] * 2d - node.x[1];
        c1.y = node.y[0] * 2d - node.y[1];
        toPathCommandHasParameter(streamTokenizer,"x2 coordinate", "S", str);
        c2.x = streamTokenizer.nval;
        toPathCommandHasParameter(streamTokenizer,"y2 coordinate", "S", str);
        c2.y = streamTokenizer.nval;
        toPathCommandHasParameter(streamTokenizer,"x coordinate", "S", str);
        p.x = streamTokenizer.nval;
        toPathCommandHasParameter(streamTokenizer,"y coordinate", "S", str);
        p.y = streamTokenizer.nval;
        path.curveTo(c1.x, c1.y, c2.x, c2.y, p.x, p.y);
        nextCommand = 'S';
        return nextCommand;
    }

    public static char relativeCurveto(StreamPosTokenizer streamTokenizer, String str, Point2D.Double c1, Point2D.Double p, Point2D.Double c2, BezierPath path) throws IOException {
        char nextCommand;
        // relative-curveto dx1 dy1 dx2 dy2 dx dy
        toPathCommandHasParameter(streamTokenizer,"dx1 coordinate", "c", str);
        c1.x = p.x + streamTokenizer.nval;
        toPathCommandHasParameter(streamTokenizer,"dy1 coordinate", "c", str);
        c1.y = p.y + streamTokenizer.nval;
        toPathCommandHasParameter(streamTokenizer,"dx2 coordinate", "c", str);
        c2.x = p.x + streamTokenizer.nval;
        toPathCommandHasParameter(streamTokenizer,"dy2 coordinate", "c", str);
        c2.y = p.y + streamTokenizer.nval;
        toPathCommandHasParameter(streamTokenizer,"dx coordinate", "c", str);
        p.x += streamTokenizer.nval;
        toPathCommandHasParameter(streamTokenizer,"dy coordinate", "c", str);
        p.y += streamTokenizer.nval;
        path.curveTo(c1.x, c1.y, c2.x, c2.y, p.x, p.y);
        nextCommand = 'c';
        return nextCommand;
    }

    public static char absoluteCurveto(StreamPosTokenizer streamTokenizer, String str, Point2D.Double c1, Point2D.Double c2, Point2D.Double p, BezierPath path) throws IOException {
        char nextCommand;
        // absolute-curveto x1 y1 x2 y2 x y
        toPathCommandHasParameter(streamTokenizer,"x1 coordinate", "C", str);
        c1.x = streamTokenizer.nval;
        toPathCommandHasParameter(streamTokenizer,"y1 coordinate", "C", str);
        c1.y = streamTokenizer.nval;
        toPathCommandHasParameter(streamTokenizer,"x2 coordinate", "C", str);
        c2.x = streamTokenizer.nval;
        toPathCommandHasParameter(streamTokenizer,"y2 coordinate", "C", str);
        c2.y = streamTokenizer.nval;
        toPathCommandHasParameter(streamTokenizer,"x coordinate", "C", str);
        p.x = streamTokenizer.nval;
        toPathCommandHasParameter(streamTokenizer,"y coordinate", "C", str);
        p.y = streamTokenizer.nval;
        path.curveTo(c1.x, c1.y, c2.x, c2.y, p.x, p.y);
        nextCommand = 'C';
        return nextCommand;
    }
    
    private static boolean wasTokenNumber(StreamPosTokenizer tokenizer) throws IOException{
        if (tokenizer.nextToken() != StreamPosTokenizer.TT_NUMBER) {
            return true;
        } else {
            return false;
        }
    }
    
    private static void toPathCommandHasParameter(StreamPosTokenizer tokenizer, String param, String cmd, String str) throws IOException{
        if (wasTokenNumber(tokenizer)) {
            throw new IOException(param + " missing for '" + cmd + "' at position " + tokenizer.getStartPosition() + " in " + str);
        }
    }
}
