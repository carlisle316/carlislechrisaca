package com.carlisle.android.aca.notetoself;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chriscarlisle on 9/19/16.
 */

public class Note {

    private String mTitle;
    private String mDescription;
    private boolean mIdea;
    private boolean mTodo;
    private boolean mImportant;
    private static final String JSON_TITLE = "title";
    private static final String JSON_DESCRIPTION = "description";
    private static final String JSON_IDEA = "idea" ;
    private static final String JSON_TODO = "todo";
    private static final String JSON_IMPORTANT = "important";

    / Constructor
    // Only used when new is called with a JSONObject
    public Note(JSONObject jo) throws JSONException {

        mTitle =  jo.getString(JSON_TITLE);
        mDescription = jo.getString(JSON_DESCRIPTION);
        mIdea = jo.getBoolean(JSON_IDEA);
        mTodo = jo.getBoolean(JSON_TODO);
        mImportant = jo.getBoolean(JSON_IMPORTANT);
    }
    // Now we must provide an empty default constructor
// for when we create a Note as we provide a
// specialized constructor that must be used.
    public Note (){

    }
    public JSONObject convertToJSON() throws JSONException{

        JSONObject jo = new JSONObject();

        jo.put(JSON_TITLE, mTitle);
        jo.put(JSON_DESCRIPTION, mDescription);
        jo.put(JSON_IDEA, mIdea);
        jo.put(JSON_TODO, mTodo);
        jo.put(JSON_IMPORTANT, mImportant);

        return jo;
    }

    public class JSONSerializer {

        private String mFilename;
        private Context mContext;

        // All the rest of the code for the class goes here

    }// End of class

    public void save(List<Note> notes)
            throws IOException, JSONException{

        // Make an array in JSON format
        JSONArray jArray = new JSONArray();

        // And load it with the notes
        for (Note n : notes)
            jArray.put(n.convertToJSON());

        // Now write it to the private disk space of our app
        Writer writer = null;
        try {
            OutputStream out = mContext.openFileOutput
                    (mFilename, mContext.MODE_PRIVATE);

            writer = new OutputStreamWriter(out);
            writer.write(jArray.toString());
        } finally {
            if (writer != null) {

                writer.close();
            }
        }
    }

    public ArrayList<Note> load() throws IOException, JSONException{
        ArrayList<Note> noteList = new ArrayList<Note>();
        BufferedReader reader = null;
        try {

            InputStream in = mContext.openFileInput(mFilename);
            reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder jsonString = new StringBuilder();
            String line = null;

            while ((line = reader.readLine()) != null) {

                jsonString.append(line);
            }


            JSONArray jArray = (JSONArray) new JSONTokener
                    (jsonString.toString()).nextValue();
            for (int i = 0; i < jArray.length(); i++) {
                noteList.add(new Note(jArray.getJSONObject(i)));
            }
        } catch (FileNotFoundException e) {
            // we will ignore this one, since it happens
            // when we start fresh. You could add a log here.
        } finally {// This will always run
            if (reader != null)
                reader.close();
        }

        return noteList;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public boolean isIdea() {
        return mIdea;
    }

    public void setIdea(boolean idea) {
        mIdea = idea;
    }

    public boolean isTodo() {
        return mTodo;
    }

    public void setTodo(boolean todo) {
        mTodo = todo;
    }

    public boolean isImportant() {
        return mImportant;
    }

    public void setImportant(boolean important) {
        mImportant = important;
    }
}
