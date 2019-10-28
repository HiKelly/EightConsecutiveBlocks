import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class UI extends JFrame{
    Graph graph;
    boolean[][] block;
    int ans;
    int n;
    JButton btn = new JButton("刷新");
    JLabel jLabel;
    JPanel buttonPanel = new JPanel();
    JPanel gridPanel = new JPanel();
    Label[][] label;

    public UI(int n) throws FileNotFoundException {
        this.n = n;
        graph = new Graph(n);
        graph.generateGraph();
        block = graph.getBlock();
        ans = graph.countEightConsecutiveBlocks();
        PrintStream ps = new PrintStream("out.txt");
        System.setOut(ps);
        System.out.println("图中有" + ans + "个八连块");
        jLabel = new JLabel("图中有" + ans + "个八连块");
        btn.setSize(20, 10);
        btn.addActionListener(new btnActionListener());
        buttonPanel.add(jLabel);
        buttonPanel.add(btn);
        initGrid();
        add(gridPanel, BorderLayout.NORTH);
        add(buttonPanel);
        this.setSize(n * 50, (n + 6) * 25);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    class btnActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            graph.generateGraph();
            ans = graph.countEightConsecutiveBlocks();
            System.out.println("图中有" + ans + "个八连块");
            jLabel.setText("图中有" + ans + "个八连块");
            changeGrid();
        }
    }

    void initGrid(){
        gridPanel = new JPanel(new GridLayout(n, n));
        label = new Label[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                label[i][j] = new Label();
                if(block[i][j])
                    label[i][j].setBackground(Color.BLACK);
                else
                    label[i][j].setBackground(Color.white);
                gridPanel.add(label[i][j]);
            }

        }
    }

    void changeGrid(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(block[i][j])
                    label[i][j].setBackground(Color.BLACK);
                else
                    label[i][j].setBackground(Color.white);
            }
        }
    }
}