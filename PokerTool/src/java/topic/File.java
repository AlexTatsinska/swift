/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topic;

/**
 *
 * @author AlexT
 */
public class File {

    private Topic topic;
    private SubTopic subTopic;
    private String filePath;
    private String fileName;

    public File(Topic topic, SubTopic subTopic, String filePath, String fileName) {
        this.topic = topic;
        this.subTopic = subTopic;
        setFilePath(filePath);
        setFileName(fileName);
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public SubTopic getSubTopic() {
        return subTopic;
    }

    public void setSubTopic(SubTopic subTopic) {
        this.subTopic = subTopic;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
