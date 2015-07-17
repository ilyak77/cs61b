import edu.princeton.cs.introcs.In;
import java.util.Set;
import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;
import edu.princeton.cs.algs4.Digraph;
//import ngordnet.GraphHelper;

public class WordNet extends Digraph {
    /** Creates a WordNet using files form SYNSETFILENAME and HYPONYMFILENAME */
   private String synset;
   private String hyponyms;
   private static int vertexNum=1000;

   private In inputSyn;
   private HashMap<Integer,String[]> synsetMap;
   private int synsetId;
   private String[] synWord;
   
   private Digraph hypoTree;
   private In inputHypo;
   private int hypoRoot;
   private int[] hypoSon;


    public WordNet(String synsetFilename, String hyponymFilename){
      synset=synsetFilename;
      hyponyms=hyponymFilename;

      synsetMap= new HashMap<Integer,String[]>();
      inputSyn=new In(synset);

      // read the ID set and hypo Set from the file synset
      String line=inputSyn.readLine();

      while(line!=null){
        String[] synset_part=line.split(",");
        synsetId=Integer.parseInt(synset_part[0]);
        String synset_part2=synset_part[1];
        synWord=synset_part2.split(" ");
        synsetMap.put(synsetId,synWord);

        line=inputSyn.readLine();

      }

      hypoTree=new Digraph(vertexNum);
      inputHypo=new In(hyponyms);
      line=inputHypo.readLine();

      while(line!=null){
        int[] hypo_part=Interger.parseInt(line.split(" "));
        hypoRoot=hypo_part[0];// the first word of each line is the root in our system

        for(int i=1;i<hypo_part.length;i++){
          hypoSon[i-1]=hypo_part[i];
          hypoTree.addEdge(hypoRoot,hypoSon[i-1]);
          
        }

        line=inputHypo.readLine();
      }


    } 

    /* Returns true if NOUN is a word in some synset. */
    public boolean isNoun(String noun){
     for(String word:this.nouns()){
       if(noun.equals(word)) return true;
     }
      
      return false;
    }

    /* Returns the set of all nouns. */
    public Set<String> nouns(){
      
      HashSet<String> noun=new HashSet<String>();
      HashSet<Integer> idSet=new HashSet<Integer>();
      
      idSet=synsetMap.keySet();
      for (int idValue : idSet){
         String[] mapValue=synsetMap.get(idValue);
         for(int i=0;i<mapValue.length;i++){
          noun.add(mapValue[i]);
         }

      }
      
      return noun;

    }

    /** Returns the set of all hyponyms of WORD as well as all synonyms of
      * WORD. If WORD belongs to multiple synsets, return all hyponyms of
      * all of these synsets. See http://goo.gl/EGLoys for an example.
      * Do not include hyponyms of synonyms.
      */
    public Set<String> hyponyms(String word){
      //find the corresponding id of word
      HashSet<String> hypoSet=new HashSet();
      //HashSet<Integer> idSet=new HashSet();
      Set idSet=synsetMap.keySet();

      HashSet<Integer> idNeed=new HashSet();
      for (int idValue : idSet){
         String[] mapValue=synsetMap.get(idValue);
         for(int i=0;i<mapValue.length;i++){
          if(mapValue[i].equals(word)) idNeed.add(idValue);
         }
      }

      HashSet<Integer> descent= new HashSet<Integer>();
      descent=GraphicHelper.descendants(hypoTree,idNeed);

      for (int idValue: idSet){
        for (int idDescent: descent){
          if(idValue==idDescent){
            String[] temp=synsetMap.get(idValue);
            for(int j=0;j<temp.length;j++){
              hypoSet.add(temp[j]);
            }
          } 
        }
      }
 
      return hypoSet;
    }

     /* HashSet<String[]> hypo=new HashSet<String>();

      HashSet<String> idSet=new HashSet();
      
      idSet=map.KeySet();
      ArrayList<String> idNeed=new ArrayList();
      for (String idValue : idSet){
         String[] mapValue=map.get(idValue);
         for(int i=0;i<mapValue.length();i++){
          if(mapValue[i].equals(word)) idNeed.add(idValue);
         }

      }

      for(String temp:idNeed){
        String[]hypo_value=mapH.get(temp);
        for(int i=0;i<hypo_value.length();i++){
          String[]temp2=map.get(hypo_value[i]));
          for(int j=0;j<temp2.length();j++){
            hypo.add(temp2[j]);
          }
        }
      }

      return hypo;
*/

    
}